/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS TRONY
 */
@Entity
@Table(name = "CorsoDiLaurea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CorsoDiLaurea.findAll", query = "SELECT c FROM CorsoDiLaurea c")
    , @NamedQuery(name = "CorsoDiLaurea.findById", query = "SELECT c FROM CorsoDiLaurea c WHERE c.id = :id")
    , @NamedQuery(name = "CorsoDiLaurea.findByNome", query = "SELECT c FROM CorsoDiLaurea c WHERE c.nome = :nome")})
public class CorsoDiLaurea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descrizione")
    private String descrizione;
    @JoinTable(name = "MaterieCorso", joinColumns = {
        @JoinColumn(name = "id_corso", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_materia", referencedColumnName = "codice")})
    @ManyToMany
    @JsonIgnore
    private Collection<Materia> materiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corso")
   @JsonIgnore
    private Collection<Studente> studenteCollection;

    public CorsoDiLaurea() {
    }

    public CorsoDiLaurea(String id) {
        this.id = id;
    }

    public CorsoDiLaurea(String id, String nome, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Studente> getStudenteCollection() {
        return studenteCollection;
    }

    public void setStudenteCollection(Collection<Studente> studenteCollection) {
        this.studenteCollection = studenteCollection;
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
        if (!(object instanceof CorsoDiLaurea)) {
            return false;
        }
        CorsoDiLaurea other = (CorsoDiLaurea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gid.myunivaq2.rest.CorsoDiLaurea[ id=" + id + " ]";
    }
    
}
