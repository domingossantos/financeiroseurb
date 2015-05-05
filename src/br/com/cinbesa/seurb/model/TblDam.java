/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinbesa.seurb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author domingos
 */
@Entity
@Table(name = "tbl_dam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDam.findAll", query = "SELECT t FROM TblDam t"),
    @NamedQuery(name = "TblDam.findByCdOrgao", query = "SELECT t FROM TblDam t WHERE t.tblDamPK.cdOrgao = :cdOrgao"),
    @NamedQuery(name = "TblDam.findByCdUsoatividade", query = "SELECT t FROM TblDam t WHERE t.cdUsoatividade = :cdUsoatividade"),
    @NamedQuery(name = "TblDam.findByCdTributo", query = "SELECT t FROM TblDam t WHERE t.tblDamPK.cdTributo = :cdTributo"),
    @NamedQuery(name = "TblDam.findByNrSequencia", query = "SELECT t FROM TblDam t WHERE t.tblDamPK.nrSequencia = :nrSequencia"),
    @NamedQuery(name = "TblDam.findByNrGuia", query = "SELECT t FROM TblDam t WHERE t.nrGuia = :nrGuia"),
    @NamedQuery(name = "TblDam.findByNrGuiaNrGuia", query = "SELECT t FROM TblDam t WHERE t.nrGuia = :nrGuia and t.tblDamPK.nrAno = :nrAno order by t.nrGuia, t.vlDam"),
    @NamedQuery(name = "TblDam.findByNrOrdem", query = "SELECT t FROM TblDam t WHERE t.nrOrdem = :nrOrdem"),
    @NamedQuery(name = "TblDam.findByVlDam", query = "SELECT t FROM TblDam t WHERE t.vlDam = :vlDam"),
    @NamedQuery(name = "TblDam.findByDtVencimento", query = "SELECT t FROM TblDam t WHERE t.dtVencimento = :dtVencimento"),
    @NamedQuery(name = "TblDam.findByDtEmissao", query = "SELECT t FROM TblDam t WHERE t.dtEmissao = :dtEmissao"),
    @NamedQuery(name = "TblDam.findByDsSituacao", query = "SELECT t FROM TblDam t WHERE t.dsSituacao = :dsSituacao"),
    @NamedQuery(name = "TblDam.findByNrParcela", query = "SELECT t FROM TblDam t WHERE t.tblDamPK.nrParcela = :nrParcela"),
    @NamedQuery(name = "TblDam.findByDtTramite", query = "SELECT t FROM TblDam t WHERE t.dtTramite = :dtTramite"),
    @NamedQuery(name = "TblDam.findByNrProcesso", query = "SELECT t FROM TblDam t WHERE t.tblDamPK.nrProcesso = :nrProcesso"),
    @NamedQuery(name = "TblDam.findByNrAno", query = "SELECT t FROM TblDam t WHERE t.tblDamPK.nrAno = :nrAno order by t.nrGuia, t.vlDam"),
    @NamedQuery(name = "TblDam.findByCdRota", query = "SELECT t FROM TblDam t WHERE t.tblDamPK.cdRota = :cdRota"),
    @NamedQuery(name = "TblDam.findByCdBarras", query = "SELECT t FROM TblDam t WHERE t.cdBarras = :cdBarras"),
    @NamedQuery(name = "TblDam.findByCdBarrasDv", query = "SELECT t FROM TblDam t WHERE t.cdBarrasDv = :cdBarrasDv"),
    @NamedQuery(name = "TblDam.findByDtPagamento", query = "SELECT t FROM TblDam t WHERE t.dtPagamento = :dtPagamento"),
    @NamedQuery(name = "TblDam.findByVlUfir", query = "SELECT t FROM TblDam t WHERE t.vlUfir = :vlUfir"),
    @NamedQuery(name = "TblDam.findByDsObservacao", query = "SELECT t FROM TblDam t WHERE t.dsObservacao = :dsObservacao"),
    @NamedQuery(name = "TblDam.findById", query = "SELECT t FROM TblDam t WHERE t.id = :id")})
public class TblDam implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDamPK tblDamPK;
    @Basic(optional = false)
    @Column(name = "cd_usoatividade")
    private int cdUsoatividade;
    @Column(name = "nr_guia")
    private String nrGuia;
    @Column(name = "nr_ordem")
    private Integer nrOrdem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vl_dam")
    private BigDecimal vlDam;
    @Column(name = "dt_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dtVencimento;
    @Column(name = "dt_emissao")
    @Temporal(TemporalType.DATE)
    private Date dtEmissao;
    @Column(name = "ds_situacao")
    private String dsSituacao;
    @Basic(optional = false)
    @Column(name = "dt_tramite")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtTramite;
    @Column(name = "cd_barras")
    private String cdBarras;
    @Column(name = "cd_barras_dv")
    private String cdBarrasDv;
    @Column(name = "dt_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dtPagamento;
    @Column(name = "vl_ufir")
    private BigDecimal vlUfir;
    @Column(name = "ds_observacao")
    private String dsObservacao;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @JoinColumn(name = "cd_valor_documento", referencedColumnName = "cd_valor_documento")
    @ManyToOne
    private TblValorDocumento cdValorDocumento;

    public TblDam() {
    }

    public TblDam(TblDamPK tblDamPK) {
        this.tblDamPK = tblDamPK;
    }

    public TblDam(TblDamPK tblDamPK, int cdUsoatividade, Date dtTramite, int id) {
        this.tblDamPK = tblDamPK;
        this.cdUsoatividade = cdUsoatividade;
        this.dtTramite = dtTramite;
        this.id = id;
    }

    public TblDam(int cdOrgao, int cdTributo, int nrSequencia, int nrParcela, int nrProcesso, short nrAno, int cdRota) {
        this.tblDamPK = new TblDamPK(cdOrgao, cdTributo, nrSequencia, nrParcela, nrProcesso, nrAno, cdRota);
    }

    public TblDamPK getTblDamPK() {
        return tblDamPK;
    }

    public void setTblDamPK(TblDamPK tblDamPK) {
        this.tblDamPK = tblDamPK;
    }

    public int getCdUsoatividade() {
        return cdUsoatividade;
    }

    public void setCdUsoatividade(int cdUsoatividade) {
        this.cdUsoatividade = cdUsoatividade;
    }

    public String getNrGuia() {
        return nrGuia;
    }

    public void setNrGuia(String nrGuia) {
        this.nrGuia = nrGuia;
    }

    public Integer getNrOrdem() {
        return nrOrdem;
    }

    public void setNrOrdem(Integer nrOrdem) {
        this.nrOrdem = nrOrdem;
    }

    public BigDecimal getVlDam() {
        return vlDam;
    }

    public void setVlDam(BigDecimal vlDam) {
        this.vlDam = vlDam;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public Date getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Date dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public String getDsSituacao() {
        return dsSituacao;
    }

    public void setDsSituacao(String dsSituacao) {
        this.dsSituacao = dsSituacao;
    }

    public Date getDtTramite() {
        return dtTramite;
    }

    public void setDtTramite(Date dtTramite) {
        this.dtTramite = dtTramite;
    }

    public String getCdBarras() {
        return cdBarras;
    }

    public void setCdBarras(String cdBarras) {
        this.cdBarras = cdBarras;
    }

    public String getCdBarrasDv() {
        return cdBarrasDv;
    }

    public void setCdBarrasDv(String cdBarrasDv) {
        this.cdBarrasDv = cdBarrasDv;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public BigDecimal getVlUfir() {
        return vlUfir;
    }

    public void setVlUfir(BigDecimal vlUfir) {
        this.vlUfir = vlUfir;
    }

    public String getDsObservacao() {
        return dsObservacao;
    }

    public void setDsObservacao(String dsObservacao) {
        this.dsObservacao = dsObservacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TblValorDocumento getCdValorDocumento() {
        return cdValorDocumento;
    }

    public void setCdValorDocumento(TblValorDocumento cdValorDocumento) {
        this.cdValorDocumento = cdValorDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblDamPK != null ? tblDamPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDam)) {
            return false;
        }
        TblDam other = (TblDam) object;
        if ((this.tblDamPK == null && other.tblDamPK != null) || (this.tblDamPK != null && !this.tblDamPK.equals(other.tblDamPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financeiroseurb.model.TblDam[ tblDamPK=" + tblDamPK + " ]";
    }
    
}
