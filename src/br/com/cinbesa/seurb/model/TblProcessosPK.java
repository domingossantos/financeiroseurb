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
public class TblProcessosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "nr_processo")
    private int nrProcesso;
    @Basic(optional = false)
    @Column(name = "nr_ano")
    private short nrAno;

    public TblProcessosPK() {
    }

    public TblProcessosPK(int nrProcesso, short nrAno) {
        this.nrProcesso = nrProcesso;
        this.nrAno = nrAno;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nrProcesso;
        hash += (int) nrAno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProcessosPK)) {
            return false;
        }
        TblProcessosPK other = (TblProcessosPK) object;
        if (this.nrProcesso != other.nrProcesso) {
            return false;
        }
        if (this.nrAno != other.nrAno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "financeiroseurb.model.TblProcessosPK[ nrProcesso=" + nrProcesso + ", nrAno=" + nrAno + " ]";
    }
    
}
