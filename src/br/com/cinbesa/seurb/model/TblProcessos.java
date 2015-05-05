/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinbesa.seurb.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author domingos
 */
@Entity
@Table(name = "tbl_processos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblProcessos.findAll", query = "SELECT t FROM TblProcessos t"),
    @NamedQuery(name = "TblProcessos.findByNrProcesso", query = "SELECT t FROM TblProcessos t WHERE t.tblProcessosPK.nrProcesso = :nrProcesso"),
    @NamedQuery(name = "TblProcessos.findByNrAno", query = "SELECT t FROM TblProcessos t WHERE t.tblProcessosPK.nrAno = :nrAno"),
    @NamedQuery(name = "TblProcessos.findByDtAberturaProcesso", query = "SELECT t FROM TblProcessos t WHERE t.dtAberturaProcesso = :dtAberturaProcesso"),
    @NamedQuery(name = "TblProcessos.findByStProcesso", query = "SELECT t FROM TblProcessos t WHERE t.stProcesso = :stProcesso"),
    @NamedQuery(name = "TblProcessos.findByStProcessoweb", query = "SELECT t FROM TblProcessos t WHERE t.stProcessoweb = :stProcessoweb"),
    @NamedQuery(name = "TblProcessos.findByDsProcesso", query = "SELECT t FROM TblProcessos t WHERE t.dsProcesso = :dsProcesso"),
    @NamedQuery(name = "TblProcessos.findByDsEncerramento", query = "SELECT t FROM TblProcessos t WHERE t.dsEncerramento = :dsEncerramento"),
    @NamedQuery(name = "TblProcessos.findByDtEncerramento", query = "SELECT t FROM TblProcessos t WHERE t.dtEncerramento = :dtEncerramento"),
    @NamedQuery(name = "TblProcessos.findByStAnonimo", query = "SELECT t FROM TblProcessos t WHERE t.stAnonimo = :stAnonimo"),
    @NamedQuery(name = "TblProcessos.findByDsEndereco", query = "SELECT t FROM TblProcessos t WHERE t.dsEndereco = :dsEndereco"),
    @NamedQuery(name = "TblProcessos.findByNrEndereco", query = "SELECT t FROM TblProcessos t WHERE t.nrEndereco = :nrEndereco"),
    @NamedQuery(name = "TblProcessos.findByDsComplemtento", query = "SELECT t FROM TblProcessos t WHERE t.dsComplemtento = :dsComplemtento"),
    @NamedQuery(name = "TblProcessos.findByNrCep", query = "SELECT t FROM TblProcessos t WHERE t.nrCep = :nrCep"),
    @NamedQuery(name = "TblProcessos.findByDsBairro", query = "SELECT t FROM TblProcessos t WHERE t.dsBairro = :dsBairro"),
    @NamedQuery(name = "TblProcessos.findByNmCidade", query = "SELECT t FROM TblProcessos t WHERE t.nmCidade = :nmCidade"),
    @NamedQuery(name = "TblProcessos.findByDsUf", query = "SELECT t FROM TblProcessos t WHERE t.dsUf = :dsUf"),
    @NamedQuery(name = "TblProcessos.findByDsComplemento", query = "SELECT t FROM TblProcessos t WHERE t.dsComplemento = :dsComplemento")})
public class TblProcessos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblProcessosPK tblProcessosPK;
    @Basic(optional = false)
    @Column(name = "dt_abertura_processo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtAberturaProcesso;
    @Basic(optional = false)
    @Column(name = "st_processo")
    private Character stProcesso;
    @Basic(optional = false)
    @Column(name = "st_processoweb")
    private Character stProcessoweb;
    @Column(name = "ds_processo")
    private String dsProcesso;
    @Column(name = "ds_encerramento")
    private String dsEncerramento;
    @Column(name = "dt_encerramento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEncerramento;
    @Column(name = "st_anonimo")
    private Character stAnonimo;
    @Column(name = "ds_endereco")
    private String dsEndereco;
    @Column(name = "nr_endereco")
    private String nrEndereco;
    @Column(name = "ds_complemtento")
    private String dsComplemtento;
    @Column(name = "nr_cep")
    private String nrCep;
    @Column(name = "ds_bairro")
    private String dsBairro;
    @Column(name = "nm_cidade")
    private String nmCidade;
    @Column(name = "ds_uf")
    private String dsUf;
    @Column(name = "ds_complemento")
    private String dsComplemento;
    @JoinColumn(name = "nr_cpf", referencedColumnName = "nr_cpf")
    @ManyToOne(optional = false)
    private TblInteressados nrCpf;
    @OneToMany(mappedBy = "tblProcessos")
    private List<TblValorDocumento> tblValorDocumentoList;

    public TblProcessos() {
    }

    public TblProcessos(TblProcessosPK tblProcessosPK) {
        this.tblProcessosPK = tblProcessosPK;
    }

    public TblProcessos(TblProcessosPK tblProcessosPK, Date dtAberturaProcesso, Character stProcesso, Character stProcessoweb) {
        this.tblProcessosPK = tblProcessosPK;
        this.dtAberturaProcesso = dtAberturaProcesso;
        this.stProcesso = stProcesso;
        this.stProcessoweb = stProcessoweb;
    }

    public TblProcessos(int nrProcesso, short nrAno) {
        this.tblProcessosPK = new TblProcessosPK(nrProcesso, nrAno);
    }

    public TblProcessosPK getTblProcessosPK() {
        return tblProcessosPK;
    }

    public void setTblProcessosPK(TblProcessosPK tblProcessosPK) {
        this.tblProcessosPK = tblProcessosPK;
    }

    public Date getDtAberturaProcesso() {
        return dtAberturaProcesso;
    }

    public void setDtAberturaProcesso(Date dtAberturaProcesso) {
        this.dtAberturaProcesso = dtAberturaProcesso;
    }

    public Character getStProcesso() {
        return stProcesso;
    }

    public void setStProcesso(Character stProcesso) {
        this.stProcesso = stProcesso;
    }

    public Character getStProcessoweb() {
        return stProcessoweb;
    }

    public void setStProcessoweb(Character stProcessoweb) {
        this.stProcessoweb = stProcessoweb;
    }

    public String getDsProcesso() {
        return dsProcesso;
    }

    public void setDsProcesso(String dsProcesso) {
        this.dsProcesso = dsProcesso;
    }

    public String getDsEncerramento() {
        return dsEncerramento;
    }

    public void setDsEncerramento(String dsEncerramento) {
        this.dsEncerramento = dsEncerramento;
    }

    public Date getDtEncerramento() {
        return dtEncerramento;
    }

    public void setDtEncerramento(Date dtEncerramento) {
        this.dtEncerramento = dtEncerramento;
    }

    public Character getStAnonimo() {
        return stAnonimo;
    }

    public void setStAnonimo(Character stAnonimo) {
        this.stAnonimo = stAnonimo;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }

    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    public String getNrEndereco() {
        return nrEndereco;
    }

    public void setNrEndereco(String nrEndereco) {
        this.nrEndereco = nrEndereco;
    }

    public String getDsComplemtento() {
        return dsComplemtento;
    }

    public void setDsComplemtento(String dsComplemtento) {
        this.dsComplemtento = dsComplemtento;
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

    public String getDsComplemento() {
        return dsComplemento;
    }

    public void setDsComplemento(String dsComplemento) {
        this.dsComplemento = dsComplemento;
    }

    public TblInteressados getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(TblInteressados nrCpf) {
        this.nrCpf = nrCpf;
    }

    @XmlTransient
    public List<TblValorDocumento> getTblValorDocumentoList() {
        return tblValorDocumentoList;
    }

    public void setTblValorDocumentoList(List<TblValorDocumento> tblValorDocumentoList) {
        this.tblValorDocumentoList = tblValorDocumentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblProcessosPK != null ? tblProcessosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProcessos)) {
            return false;
        }
        TblProcessos other = (TblProcessos) object;
        if ((this.tblProcessosPK == null && other.tblProcessosPK != null) || (this.tblProcessosPK != null && !this.tblProcessosPK.equals(other.tblProcessosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financeiroseurb.model.TblProcessos[ tblProcessosPK=" + tblProcessosPK + " ]";
    }
    
}
