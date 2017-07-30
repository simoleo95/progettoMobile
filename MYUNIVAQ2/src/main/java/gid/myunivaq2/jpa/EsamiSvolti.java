/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS TRONY
 */
@Entity
@Table(name = "EsamiSvolti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EsamiSvolti.findAll", query = "SELECT e FROM EsamiSvolti e")
    , @NamedQuery(name = "EsamiSvolti.findByFkMateria", query = "SELECT e FROM EsamiSvolti e WHERE e.esamiSvoltiPK.fkMateria = :fkMateria")
    , @NamedQuery(name = "EsamiSvolti.findByFkStudente", query = "SELECT e FROM EsamiSvolti e WHERE e.esamiSvoltiPK.fkStudente = :fkStudente")
    , @NamedQuery(name = "EsamiSvolti.findByVoto", query = "SELECT e FROM EsamiSvolti e WHERE e.voto = :voto")})
public class EsamiSvolti implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EsamiSvoltiPK esamiSvoltiPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "voto")
    private int voto;
    @JoinColumn(name = "fk_materia", referencedColumnName = "codice", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Materia materia;
    @JoinColumn(name = "fk_studente", referencedColumnName = "matricola", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Studente studente;
    @JoinColumn(name = "fk_appello", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Appello fkAppello;

    public EsamiSvolti() {
    }

    public EsamiSvolti(EsamiSvoltiPK esamiSvoltiPK) {
        this.esamiSvoltiPK = esamiSvoltiPK;
    }

    public EsamiSvolti(EsamiSvoltiPK esamiSvoltiPK, int voto) {
        this.esamiSvoltiPK = esamiSvoltiPK;
        this.voto = voto;
    }

    public EsamiSvolti(String fkMateria, int fkStudente) {
        this.esamiSvoltiPK = new EsamiSvoltiPK(fkMateria, fkStudente);
    }

    public EsamiSvoltiPK getEsamiSvoltiPK() {
        return esamiSvoltiPK;
    }

    public void setEsamiSvoltiPK(EsamiSvoltiPK esamiSvoltiPK) {
        this.esamiSvoltiPK = esamiSvoltiPK;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Studente getStudente() {
        return studente;
    }

    public void setStudente(Studente studente) {
        this.studente = studente;
    }

    public Appello getFkAppello() {
        return fkAppello;
    }

    public void setFkAppello(Appello fkAppello) {
        this.fkAppello = fkAppello;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (esamiSvoltiPK != null ? esamiSvoltiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EsamiSvolti)) {
            return false;
        }
        EsamiSvolti other = (EsamiSvolti) object;
        if ((this.esamiSvoltiPK == null && other.esamiSvoltiPK != null) || (this.esamiSvoltiPK != null && !this.esamiSvoltiPK.equals(other.esamiSvoltiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gid.myunivaq2.rest.EsamiSvolti[ esamiSvoltiPK=" + esamiSvoltiPK + " ]";
    }
    
}
