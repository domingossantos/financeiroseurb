/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinbesa.seurb.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author domingos
 */
public class DamDTO {
    private Integer id;
    
    private String guia;
    
    
    private String emissao;
    
    private String vencimento;
    
    private BigDecimal valor;
    
    private Integer parcelas;

    private Integer parcela;
    
    private String codigoBarras;
    
    private String cpfCnpj;
    
    private Integer processo;
    
    private Integer ano;

    private String usoatividade;



    /**
     * @return the guia
     */
    public String getGuia() {
        return guia;
    }

    /**
     * @param guia the guia to set
     */
    public void setGuia(String guia) {
        this.guia = guia;
    }

    /**
     * @return the emissao
     */
    public String getEmissao() {
        return emissao;
    }

    /**
     * @param emissao the emissao to set
     */
    public void setEmissao(String emissao) {
        this.emissao = emissao;
    }

    /**
     * @return the vencimento
     */
    public String getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getParcela() {
        return parcela;
    }

    public void setParcela(Integer parcela) {
        this.parcela = parcela;
    }

    /**
     * @return the parcelas
     */
    public Integer getParcelas() {
        return parcelas;
    }

    /**
     * @param parcelas the parcelas to set
     */
    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    /**
     * @return the codigoBarras
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * @param codigoBarras the codigoBarras to set
     */
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    /**
     * @return the cpfCnpj
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * @param cpfCnpj the cpfCnpj to set
     */
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    /**
     * @return the processo
     */
    public Integer getProcesso() {
        return processo;
    }

    /**
     * @param processo the processo to set
     */
    public void setProcesso(Integer processo) {
        this.processo = processo;
    }

    /**
     * @return the ano
     */
    public Integer getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(Integer ano) {
        this.ano = ano;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    public String getUsoatividade() {
        return usoatividade;
    }

    public void setUsoatividade(String usoatividade) {
        this.usoatividade = usoatividade;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.guia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DamDTO other = (DamDTO) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.guia, other.guia)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
