/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cinbesa.seurb.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author domingos
 */
@Embeddable
public class TblDamPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "cd_orgao")
    private int cdOrgao;
    @Basic(optional = false)
    @Column(name = "cd_tributo")
    private int cdTributo;
    @Basic(optional = false)
    @Column(name = "nr_sequencia")
    private int nrSequencia;
    @Basic(optional = false)
    @Column(name = "nr_parcela")
    private int nrParcela;
    @Basic(optional = false)
    @Column(name = "nr_processo")
    private int nrProcesso;
    @Basic(optional = false)
    @Column(name = "nr_ano")
    private short nrAno;
    @Basic(optional = false)
    @Column(name = "cd_rota")
    private int cdRota;

    public TblDamPK() {
    }

    public TblDamPK(int cdOrgao, int cdTributo, int nrSequencia, int nrParcela, int nrProcesso, short nrAno, int cdRota) {
        this.cdOrgao = cdOrgao;
        this.cdTributo = cdTributo;
        this.nrSequencia = nrSequencia;
        this.nrParcela = nrParcela;
        this.nrProcesso = nrProcesso;
        this.nrAno = nrAno;
        this.cdRota = cdRota;
    }

    public int getCdOrgao() {
        return cdOrgao;
    }

    public void setCdOrgao(int cdOrgao) {
        this.cdOrgao = cdOrgao;
    }

    public int getCdTributo() {
        return cdTributo;
    }

    public void setCdTributo(int cdTributo) {
        this.cdTributo = cdTributo;
    }

    public int getNrSequencia() {
        return nrSequencia;
    }

    public void setNrSequencia(int nrSequencia) {
        this.nrSequencia = nrSequencia;
    }

    public int getNrParcela() {
        return nrParcela;
    }

    public void setNrParcela(int nrParcela) {
        this.nrParcela = nrParcela;
    }

    public int getNrProcesso() {
        return nrProcesso;
    }

    public void setNrProcesso(int nrProcesso) {
        this.nrProcesso = nrProcesso;
    }

    public short getNrAno() {
        return nrAno;
    }

    public void setNrAno(short nrAno) {
        this.nrAno = nrAno;
    }

    public int getCdRota() {
        return cdRota;
    }

    public void setCdRota(int cdRota) {
        this.cdRota = cdRota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) cdOrgao;
        hash += (int) cdTributo;
        hash += (int) nrSequencia;
        hash += (int) nrParcela;
        hash += (int) nrProcesso;
        hash += (int) nrAno;
        hash += (int) cdRota;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDamPK)) {
            return false;
        }
        TblDamPK other = (TblDamPK) object;
        if (this.cdOrgao != other.cdOrgao) {
            return false;
        }
        if (this.cdTributo != other.cdTributo) {
            return false;
        }
        if (this.nrSequencia != other.nrSequencia) {
            return false;
        }
        if (this.nrParcela != other.nrParcela) {
            return false;
        }
        if (this.nrProcesso != other.nrProcesso) {
            return false;
        }
        if (this.nrAno != other.nrAno) {
            return false;
        }
        if (this.cdRota != other.cdRota) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financeiroseurb.model.TblDamPK[ cdOrgao=" + cdOrgao + ", cdTributo=" + cdTributo + ", nrSequencia=" + nrSequencia + ", nrParcela=" + nrParcela + ", nrProcesso=" + nrProcesso + ", nrAno=" + nrAno + ", cdRota=" + cdRota + " ]";
    }
    
}
