/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinbesa.seurb.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author domingos
 */
@Entity
@Table(name = "tbl_interessados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblInteressados.findAll", query = "SELECT t FROM TblInteressados t"),
    @NamedQuery(name = "TblInteressados.findByNrCpf", query = "SELECT t FROM TblInteressados t WHERE t.nrCpf = :nrCpf"),
    @NamedQuery(name = "TblInteressados.findByNmInteressado", query = "SELECT t FROM TblInteressados t WHERE t.nmInteressado = :nmInteressado"),
    @NamedQuery(name = "TblInteressados.findByNrMatricula", query = "SELECT t FROM TblInteressados t WHERE t.nrMatricula = :nrMatricula"),
    @NamedQuery(name = "TblInteressados.findByDsEndereco", query = "SELECT t FROM TblInteressados t WHERE t.dsEndereco = :dsEndereco"),
    @NamedQuery(name = "TblInteressados.findByDsEmail", query = "SELECT t FROM TblInteressados t WHERE t.dsEmail = :dsEmail"),
    @NamedQuery(name = "TblInteressados.findByVlSenha", query = "SELECT t FROM TblInteressados t WHERE t.vlSenha = :vlSenha"),
    @NamedQuery(name = "TblInteressados.findByNrEndereco", query = "SELECT t FROM TblInteressados t WHERE t.nrEndereco = :nrEndereco"),
    @NamedQuery(name = "TblInteressados.findByDsComplemento", query = "SELECT t FROM TblInteressados t WHERE t.dsComplemento = :dsComplemento"),
    @NamedQuery(name = "TblInteressados.findByNrCep", query = "SELECT t FROM TblInteressados t WHERE t.nrCep = :nrCep"),
    @NamedQuery(name = "TblInteressados.findByDsBairro", query = "SELECT t FROM TblInteressados t WHERE t.dsBairro = :dsBairro"),
    @NamedQuery(name = "TblInteressados.findByNmCidade", query = "SELECT t FROM TblInteressados t WHERE t.nmCidade = :nmCidade"),
    @NamedQuery(name = "TblInteressados.findByDsUf", query = "SELECT t FROM TblInteressados t WHERE t.dsUf = :dsUf")})
public class TblInteressados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nr_cpf")
    private String nrCpf;
    @Basic(optional = false)
    @Column(name = "nm_interessado")
    private String nmInteressado;
    @Column(name = "nr_matricula")
    private String nrMatricula;
    @Basic(optional = false)
    @Column(name = "ds_endereco")
    private String dsEndereco;
    @Column(name = "ds_email")
    private String dsEmail;
    @Basic(optional = false)
    @Column(name = "vl_senha")
    private String vlSenha;
    @Column(name = "nr_endereco")
    private String nrEndereco;
    @Column(name = "ds_complemento")
    private String dsComplemento;
    @Column(name = "nr_cep")
    private String nrCep;
    @Column(name = "ds_bairro")
    private String dsBairro;
    @Column(name = "nm_cidade")
    private String nmCidade;
    @Column(name = "ds_uf")
    private String dsUf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrCpf")
    private List<TblProcessos> tblProcessosList;

    public TblInteressados() {
    }

    public TblInteressados(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public TblInteressados(String nrCpf, String nmInteressado, String dsEndereco, String vlSenha) {
        this.nrCpf = nrCpf;
        this.nmInteressado = nmInteressado;
        this.dsEndereco = dsEndereco;
        this.vlSenha = vlSenha;
    }

    public String getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(String nrCpf) {
        this.nrCpf = nrCpf;
    }

    public String getNmInteressado() {
        return nmInteressado;
    }

    public void setNmInteressado(String nmInteressado) {
        this.nmInteressado = nmInteressado;
    }

    public String getNrMatricula() {
        return nrMatricula;
    }

    public void setNrMatricula(String nrMatricula) {
        this.nrMatricula = nrMatricula;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }

    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getVlSenha() {
        return vlSenha;
    }

    public void setVlSenha(String vlSenha) {
        this.vlSenha = vlSenha;
    }

    public String getNrEndereco() {
        return nrEndereco;
    }

    public void setNrEndereco(String nrEndereco) {
        this.nrEndereco = nrEndereco;
    }

    public String getDsComplemento() {
        return dsComplemento;
    }

    public void setDsComplemento(String dsComplemento) {
        this.dsComplemento = dsComplemento;
    }

    public String getNrCep() {
        return nrCep;
    }

    public void setNrCep(String nrCep) {
        this.nrCep = nrCep;
    }

    public String getDsBairro() {
        return dsBairro;
    }

    public void setDsBairro(String dsBairro) {
        this.dsBairro = dsBairro;
    }

    public String getNmCidade() {
        return nmCidade;
    }

    public void setNmCidade(String nmCidade) {
        this.nmCidade = nmCidade;
    }

    public String getDsUf() {
        return dsUf;
    }

    public void setDsUf(String dsUf) {
        this.dsUf = dsUf;
    }

    @XmlTransient
    public List<TblProcessos> getTblProcessosList() {
        return tblProcessosList;
    }

    public void setTblProcessosList(List<TblProcessos> tblProcessosList) {
        this.tblProcessosList = tblProcessosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrCpf != null ? nrCpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblInteressados)) {
            return false;
        }
        TblInteressados other = (TblInteressados) object;
        if ((this.nrCpf == null && other.nrCpf != null) || (this.nrCpf != null && !this.nrCpf.equals(other.nrCpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financeiroseurb.model.TblInteressados[ nrCpf=" + nrCpf + " ]";
    }
    
}
