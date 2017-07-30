/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "Professore")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professore.findAll", query = "SELECT p FROM Professore p")
    , @NamedQuery(name = "Professore.findById", query = "SELECT p FROM Professore p WHERE p.id = :id")
    , @NamedQuery(name = "Professore.findByNome", query = "SELECT p FROM Professore p WHERE p.nome = :nome")
    , @NamedQuery(name = "Professore.findByCognome", query = "SELECT p FROM Professore p WHERE p.cognome = :cognome")
    , @NamedQuery(name = "Professore.findByDataDiNascita", query = "SELECT p FROM Professore p WHERE p.dataDiNascita = :dataDiNascita")})
public class Professore implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cognome")
    private String cognome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataDiNascita")
    @Temporal(TemporalType.DATE)
    private Date dataDiNascita;
    @ManyToMany(mappedBy = "professoreCollection")
    private Collection<Materia> materiaCollection;

    public Professore() {
    }

    public Professore(Integer id) {
        this.id = id;
    }

    public Professore(Integer id, String nome, String cognome, Date dataDiNascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    @XmlTransient
    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
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
        if (!(object instanceof Professore)) {
            return false;
        }
        Professore other = (Professore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gid.myunivaq2.rest.Professore[ id=" + id + " ]";
    }
    
}
