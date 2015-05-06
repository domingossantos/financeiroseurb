package br.com.cinbesa.seurb;

import br.com.cinbesa.seurb.dto.DamDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


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
                    "	id, \n" +
                    "	nr_guia as guia, \n" +
                    "	to_char(max(dt_emissao),'YYYYMMDD') as emissao, \n" +
                    "	to_char(max(dt_vencimento),'YYYYMMDD') as vencimento , \n" +
                    "	max(vl_dam) * (select nr_parcelas from tbl_valor_documento v where v.cd_valor_documento = d.cd_valor_documento ) as valor, \n" +
                    "	(select nr_parcelas from tbl_valor_documento v where v.cd_valor_documento = d.cd_valor_documento ) as parcelas, \n" +
                    "	max(cd_barras) as codigoBarras, \n" +
                    "	(select nr_cpf from tbl_processos p where p.nr_ano = d.nr_ano and p.nr_processo = d.nr_processo) as cpfCnpj, \n" +
                    "	nr_processo as processo, \n" +
                    "	nr_ano as ano \n" +
                    "from tbl_dam d \n" +
                    "where nr_ano = 2015 and nr_parcela = 1 \n" +
                    "group by id,nr_guia,cd_orgao, cd_tipodocumento, cd_tributo, nr_sequencia, nr_ano, nr_processo, cd_rota, cd_valor_documento \n" +
                    "order by nr_guia";

            //Query q = em.createNamedQuery("TblDam.findByNrAno");
            //Query q = em.createNamedQuery("TblDam.findByNrGuiaNrGuia");
            //q.setMaxResults(50);

            Query q = em.createNativeQuery(sql, DamDTO.class);


            //q.setParameter("nrAno", 2015);
            //q.setParameter("nrGuia", "270100013-5");

            List<DamDTO> dams = q.getResultList();

            System.out.println("Consulta de DAM 2015");
            System.out.println("Quantidade de DAM: "+dams.size());

            List<DamDTO> damsNovas = new ArrayList<DamDTO>();
            DamDTO damTroca = new DamDTO();
            for(DamDTO dam : dams){

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
            String path = "/home/domingos/tmp/seurb/";

            Calendar c = Calendar.getInstance();

            String nomeArquivo = "FINANCEIRO-"+String.valueOf(c.DAY_OF_MONTH)+String.valueOf(c.WEEK_OF_MONTH)+String.valueOf(c.YEAR)+".txt";



            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path+nomeArquivo));
            String linha = "";
            Scanner in = new Scanner(System.in);

            //linha = in.nextLine();

            for(DamDTO dam : damsNovas){

                linha = dam.getGuia().replace("-","");
                linha += dam.getEmissao().toString();
                linha += dam.getVencimento().toString();
                linha += adicionaCaracter(dam.getValor().toString().replace(".", ""),"0",15,'E');
                linha += adicionaCaracter(dam.getParcelas().toString() ,"0",2,'E').substring(0, 2);
                linha += dam.getCodigoBarras().substring(0,40)+dam.getAno();
                linha += adicionaCaracter(dam.getProcesso().toString(), "0", 10, 'E');
                linha += adicionaCaracter(dam.getAno().toString(), "0",4, 'E');
                linha += adicionaCaracter(dam.getCpfCnpj().toString(), " ", 14, 'D');
                buffWrite.append(linha + "\n");

                //System.out.println(linha);
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
}
