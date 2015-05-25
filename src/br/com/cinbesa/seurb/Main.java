package br.com.cinbesa.seurb;

import br.com.cinbesa.seurb.dto.DamDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Main {

    public static void main(String[] args) {
	// write your code here

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("seurbPU");
        EntityManager em = emf.createEntityManager();

        try{
            System.out.println("####################################");
            System.out.println("Iniciando Geração de Arquivo");
            System.out.println("####################################");


            String sql = "select \n" +
                    "nr_guia as guia, \n" +
                    "to_char(max(dt_emissao),'YYYYMMDD') as emissao, \n" +
                    "to_char(max(dt_vencimento),'YYYYMMDD') as vencimento ,\n" +
                    "max(vl_dam) * (select nr_parcelas from tbl_valor_documento v where v.cd_valor_documento = d.cd_valor_documento ) as valor, \n" +
                    "(select nr_parcelas from tbl_valor_documento v where v.cd_valor_documento = d.cd_valor_documento ) as parcelas, \n" +
                    "max(cd_barras) as codigoBarras, \n" +
                    "(select CAST (nr_cpf AS varchar) from tbl_processos p where p.nr_ano = d.nr_ano and p.nr_processo = d.nr_processo) as cpfCnpj, \n" +
                    "nr_processo as processo, nr_ano as ano,\n" +
                    "(select CAST(cd_documento as varchar) from tbl_usoatividade a where a.cd_usoatividade = d.cd_usoatividade) as cd_usoatividade\n" +
                    "from tbl_dam d \n" +
                    "where nr_parcela = 1 and nr_ano >= 2015\n" +
                    "group by nr_guia,cd_orgao, cd_tipodocumento, cd_tributo, nr_sequencia, nr_ano, nr_processo, cd_rota, cd_valor_documento,d.cd_usoatividade \n" +
                    "order by nr_ano, nr_guia";



            Query q = em.createNativeQuery(sql);

            List dams = q.getResultList();

            System.out.println("Consulta de DAM 2015");
            System.out.println("Quantidade de DAM: "+dams.size());

            List<DamDTO> damsNovas = new ArrayList<DamDTO>();
            DamDTO damTroca = new DamDTO();
            for(Object objRow : dams){
                DamDTO dam = getDam((Object[]) objRow);

                if(damsNovas.size() > 0){

                    damsNovas.add(dam);
                    for(int i = 0; i < damsNovas.size(); i++){

                        damTroca = damsNovas.get(i);

                        if(damTroca.getGuia().equals(dam.getGuia())){

                            int valor = damTroca.getValor().compareTo(dam.getValor());

                            if(valor == -1){
                                damsNovas.remove(dam);
                            }

                            if(valor == 1){
                                damsNovas.remove(damTroca);
                                damsNovas.add(dam);
                            }



                        }
                    }
                } else {
                    damsNovas.add(dam);
                }

            }

            System.out.println("Qtd "+damsNovas.size());
            //String path = "/home/gilson/Desktop/";

            String path = "/Users/domingos/temp/";

            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            Calendar c = Calendar.getInstance();

            String nomeArquivo = "FINANCEIRO-"+sdf.format(c.getTime())+".txt";



            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path+nomeArquivo));
            String linha = "";

            for(DamDTO dam : damsNovas){

                linha = dam.getGuia().replace("-","");
                linha += dam.getEmissao().toString();
                linha += dam.getVencimento().toString();
                linha += adicionaCaracter(dam.getValor().toString().replace(".", ""), "0", 15, 'E');
                linha += adicionaCaracter(dam.getParcelas().toString() ,"0",2,'E').substring(0, 2);
                linha += dam.getCodigoBarras().substring(0,40)+dam.getAno();
                linha += adicionaCaracter(dam.getProcesso().toString(), "0", 10, 'E');
                linha += adicionaCaracter(dam.getAno().toString(), "0",4, 'E');
                linha += adicionaCaracter(dam.getCpfCnpj().toString(), "0", 14, 'E');
                linha += adicionaCaracter(dam.getUsoatividade().toString(), " ", 2, 'E');
                buffWrite.append(linha + "\n");
            }

            buffWrite.close();

        }
        catch (IOException iox){
            System.out.println(iox.getStackTrace());
        }
        finally{
            em.close();
            emf.close();
        }

    }

    public static String adicionaCaracter(String origem, String novoCaracter ,Integer tamanho, char posicao ){
        String nova = "";

        Integer falta = tamanho - origem.length();

        for (int i = 0; i < falta; i++) {
            nova += novoCaracter;
        }

        if(posicao == 'D'){
            nova = origem + nova;
        } else {
            nova = nova + origem;
        }

        return nova;
    }

    private static DamDTO getDam(Object[] damRow) {
        DamDTO dam = new DamDTO();
        dam.setGuia(damRow[0].toString());
        dam.setEmissao(damRow[1].toString());
        dam.setVencimento(damRow[2].toString());
        dam.setValor(new BigDecimal(damRow[3].toString()));
        dam.setParcelas(new Integer(damRow[4].toString()));
        dam.setCodigoBarras(damRow[5].toString());
        dam.setCpfCnpj(damRow[6].toString());
        dam.setProcesso(new Integer(damRow[7].toString()));
        dam.setAno(new Integer(damRow[8].toString()));
        dam.setUsoatividade(damRow[9].toString());
        return dam;
    }
}