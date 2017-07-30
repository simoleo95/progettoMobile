/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.jpa;

import com.fasterxml.jackson.annotation.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "Studente")
@XmlRootElement
@JsonRootName(value = "Studente")
@NamedQueries({
    @NamedQuery(name = "Studente.findAll", query = "SELECT s FROM Studente s")
    , @NamedQuery(name = "Studente.findByMatricola", query = "SELECT s FROM Studente s WHERE s.matricola = :matricola")
    , @NamedQuery(name = "Studente.findByNome", query = "SELECT s FROM Studente s WHERE s.nome = :nome")
    , @NamedQuery(name = "Studente.findByCognome", query = "SELECT s FROM Studente s WHERE s.cognome = :cognome")
    , @NamedQuery(name = "Studente.findByDataDiNascita", query = "SELECT s FROM Studente s WHERE s.dataDiNascita = :dataDiNascita")})
public class Studente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "matricola")
    private Integer matricola;
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
    @ManyToMany(mappedBy = "studenteCollection")
    @JsonIgnore
    private Collection<Materia> materiaCollection;
    @JoinColumn(name = "corso", referencedColumnName = "id")
    @ManyToOne(optional = false)
   @JsonIgnore
    private CorsoDiLaurea corso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studente")
    @JsonIgnore
    private Collection<EsamiSvolti> esamiSvoltiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studenteFk")
    @JsonIgnore
    private Collection<Tassa> tassaCollection;

    public Studente() {
    }

    public Studente(Integer matricola) {
        this.matricola = matricola;
    }

    public Studente(Integer matricola, String nome, String cognome, Date dataDiNascita) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public Integer getMatricola() {
        return matricola;
    }

    public void setMatricola(Integer matricola) {
        this.matricola = matricola;
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
    @JsonIgnore
    public Collection<Materia> getMateriaCollection() {
        return materiaCollection;
    }
    @JsonProperty
    public void setMateriaCollection(Collection<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    public CorsoDiLaurea getCorso() {
        return corso;
    }

    public void setCorso(CorsoDiLaurea corso) {
        this.corso = corso;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<EsamiSvolti> getEsamiSvoltiCollection() {
        return esamiSvoltiCollection;
    }
    @JsonProperty
    public void setEsamiSvoltiCollection(Collection<EsamiSvolti> esamiSvoltiCollection) {
        this.esamiSvoltiCollection = esamiSvoltiCollection;
    }

    @XmlTransient
     @JsonIgnore
    public Collection<Tassa> getTassaCollection() {
        return tassaCollection;
    }
    @JsonProperty
    public void setTassaCollection(Collection<Tassa> tassaCollection) {
        this.tassaCollection = tassaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricola != null ? matricola.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studente)) {
            return false;
        }
        Studente other = (Studente) object;
        if ((this.matricola == null && other.matricola != null) || (this.matricola != null && !this.matricola.equals(other.matricola))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gid.myunivaq2.rest.Studente[ matricola=" + matricola + " ]";
    }
    
}
