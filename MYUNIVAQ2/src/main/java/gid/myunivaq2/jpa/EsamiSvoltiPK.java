/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ASUS TRONY
 */
@Embeddable
public class EsamiSvoltiPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "fk_materia")
    private String fkMateria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_studente")
    private int fkStudente;

    public EsamiSvoltiPK() {
    }

    public EsamiSvoltiPK(String fkMateria, int fkStudente) {
        this.fkMateria = fkMateria;
        this.fkStudente = fkStudente;
    }

    public String getFkMateria() {
        return fkMateria;
    }

    public void setFkMateria(String fkMateria) {
        this.fkMateria = fkMateria;
    }

    public int getFkStudente() {
        return fkStudente;
    }

    public void setFkStudente(int fkStudente) {
        this.fkStudente = fkStudente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fkMateria != null ? fkMateria.hashCode() : 0);
        hash += (int) fkStudente;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsamiSvoltiPK)) {
            return false;
        }
        EsamiSvoltiPK other = (EsamiSvoltiPK) object;
        if ((this.fkMateria == null && other.fkMateria != null) || (this.fkMateria != null && !this.fkMateria.equals(other.fkMateria))) {
            return false;
        }
        if (this.fkStudente != other.fkStudente) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gid.myunivaq2.rest.EsamiSvoltiPK[ fkMateria=" + fkMateria + ", fkStudente=" + fkStudente + " ]";
    }
    
}
