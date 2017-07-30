/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS TRONY
 */
@Entity
@Table(name = "Aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aula.findAll", query = "SELECT a FROM Aula a")
    , @NamedQuery(name = "Aula.findById", query = "SELECT a FROM Aula a WHERE a.id = :id")
    , @NamedQuery(name = "Aula.findByBlocco", query = "SELECT a FROM Aula a WHERE a.blocco = :blocco")})
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "blocco")
    private String blocco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aula")
    private Collection<Appello> appelloCollection;

    public Aula() {
    }

    public Aula(String id) {
        this.id = id;
    }

    public Aula(String id, String blocco) {
        this.id = id;
        this.blocco = blocco;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBlocco() {
        return blocco;
    }

    public void setBlocco(String blocco) {
        this.blocco = blocco;
    }

    @XmlTransient
    public Collection<Appello> getAppelloCollection() {
        return appelloCollection;
    }

    public void setAppelloCollection(Collection<Appello> appelloCollection) {
        this.appelloCollection = appelloCollection;
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
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gid.myunivaq2.rest.Aula[ id=" + id + " ]";
    }
    
}
