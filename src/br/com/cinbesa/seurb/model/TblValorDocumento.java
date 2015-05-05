/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinbesa.seurb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "tbl_valor_documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblValorDocumento.findAll", query = "SELECT t FROM TblValorDocumento t"),
    @NamedQuery(name = "TblValorDocumento.findByCdValorDocumento", query = "SELECT t FROM TblValorDocumento t WHERE t.cdValorDocumento = :cdValorDocumento"),
    @NamedQuery(name = "TblValorDocumento.findByVlDocumento", query = "SELECT t FROM TblValorDocumento t WHERE t.vlDocumento = :vlDocumento"),
    @NamedQuery(name = "TblValorDocumento.findByDtLancamento", query = "SELECT t FROM TblValorDocumento t WHERE t.dtLancamento = :dtLancamento"),
    @NamedQuery(name = "TblValorDocumento.findByNrParcelas", query = "SELECT t FROM TblValorDocumento t WHERE t.nrParcelas = :nrParcelas"),
    @NamedQuery(name = "TblValorDocumento.findByVlUfirUsada", query = "SELECT t FROM TblValorDocumento t WHERE t.vlUfirUsada = :vlUfirUsada")})
public class TblValorDocumento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cd_valor_documento")
    private Integer cdValorDocumento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_documento")
    private BigDecimal vlDocumento;
    @Column(name = "dt_lancamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtLancamento;
    @Column(name = "nr_parcelas")
    private Integer nrParcelas;
    @Column(name = "vl_ufir_usada")
    private BigDecimal vlUfirUsada;
    @OneToMany(mappedBy = "cdValorDocumento")
    private List<TblDam> tblDamList;
    @JoinColumns({
        @JoinColumn(name = "nr_processo", referencedColumnName = "nr_processo"),
        @JoinColumn(name = "nr_ano", referencedColumnName = "nr_ano")})
    @ManyToOne
    private TblProcessos tblProcessos;

    public TblValorDocumento() {
    }

    public TblValorDocumento(Integer cdValorDocumento) {
        this.cdValorDocumento = cdValorDocumento;
    }

    public Integer getCdValorDocumento() {
        return cdValorDocumento;
    }

    public void setCdValorDocumento(Integer cdValorDocumento) {
        this.cdValorDocumento = cdValorDocumento;
    }

    public BigDecimal getVlDocumento() {
        return vlDocumento;
    }

    public void setVlDocumento(BigDecimal vlDocumento) {
        this.vlDocumento = vlDocumento;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public Integer getNrParcelas() {
        return nrParcelas;
    }

    public void setNrParcelas(Integer nrParcelas) {
        this.nrParcelas = nrParcelas;
    }

    public BigDecimal getVlUfirUsada() {
        return vlUfirUsada;
    }

    public void setVlUfirUsada(BigDecimal vlUfirUsada) {
        this.vlUfirUsada = vlUfirUsada;
    }

    @XmlTransient
    public List<TblDam> getTblDamList() {
        return tblDamList;
    }

    public void setTblDamList(List<TblDam> tblDamList) {
        this.tblDamList = tblDamList;
    }

    public TblProcessos getTblProcessos() {
        return tblProcessos;
    }

    public void setTblProcessos(TblProcessos tblProcessos) {
        this.tblProcessos = tblProcessos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdValorDocumento != null ? cdValorDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblValorDocumento)) {
            return false;
        }
        TblValorDocumento other = (TblValorDocumento) object;
        if ((this.cdValorDocumento == null && other.cdValorDocumento != null) || (this.cdValorDocumento != null && !this.cdValorDocumento.equals(other.cdValorDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financeiroseurb.model.TblValorDocumento[ cdValorDocumento=" + cdValorDocumento + " ]";
    }
    
}
