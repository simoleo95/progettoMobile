/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS TRONY
 */
@Entity
@Table(name = "Appello")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appello.findAll", query = "SELECT a FROM Appello a")
    , @NamedQuery(name = "Appello.findById", query = "SELECT a FROM Appello a WHERE a.id = :id")
    , @NamedQuery(name = "Appello.findByDataEsame", query = "SELECT a FROM Appello a WHERE a.dataEsame = :dataEsame")})
public class Appello implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_esame")
    @Temporal(TemporalType.DATE)
    private Date dataEsame;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descrizione")
    private String descrizione;
    @JoinColumn(name = "aula", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Aula aula;
    @JoinColumn(name = "fk_materia", referencedColumnName = "codice")
    @ManyToOne(optional = false)
    private Materia fkMateria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAppello")
    private Collection<EsamiSvolti> esamiSvoltiCollection;

    public Appello() {
    }

    public Appello(Integer id) {
        this.id = id;
    }

    public Appello(Integer id, Date dataEsame, String descrizione) {
        this.id = id;
        this.dataEsame = dataEsame;
        this.descrizione = descrizione;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEsame() {
        return dataEsame;
    }

    public void setDataEsame(Date dataEsame) {
        this.dataEsame = dataEsame;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Materia getFkMateria() {
        return fkMateria;
    }

    public void setFkMateria(Materia fkMateria) {
        this.fkMateria = fkMateria;
    }

     @XmlTransient
     @JsonIgnore
    public Collection<EsamiSvolti> getEsamiSvoltiCollection() {
        return esamiSvoltiCollection;
    }
     @XmlTransient
     @JsonIgnore
    public void setEsamiSvoltiCollection(Collection<EsamiSvolti> esamiSvoltiCollection) {
        this.esamiSvoltiCollection = esamiSvoltiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appello)) {
            return false;
        }
        Appello other = (Appello) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gid.myunivaq2.rest.Appello[ id=" + id + " ]";
    }
    
}
