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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "Materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m")
    , @NamedQuery(name = "Materia.findByCodice", query = "SELECT m FROM Materia m WHERE m.codice = :codice")
    , @NamedQuery(name = "Materia.findByNome", query = "SELECT m FROM Materia m WHERE m.nome = :nome")
    , @NamedQuery(name = "Materia.findByAnno", query = "SELECT m FROM Materia m WHERE m.anno = :anno")
    , @NamedQuery(name = "Materia.findByCfu", query = "SELECT m FROM Materia m WHERE m.cfu = :cfu")
    , @NamedQuery(name = "Materia.findByTipoCfu", query = "SELECT m FROM Materia m WHERE m.tipoCfu = :tipoCfu")
    , @NamedQuery(name = "Materia.findBySemestre", query = "SELECT m FROM Materia m WHERE m.semestre = :semestre")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "codice")
    private String codice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anno")
    @Temporal(TemporalType.DATE)
    private Date anno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cfu")
    private int cfu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tipoCfu")
    private String tipoCfu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestre")
    private int semestre;
    @JoinTable(name = "insegnamento", joinColumns = {
        @JoinColumn(name = "fk_materia", referencedColumnName = "codice")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_professore", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Professore> professoreCollection;
    @ManyToMany(mappedBy = "materiaCollection")
    private Collection<CorsoDiLaurea> corsoDiLaureaCollection;
    @JoinTable(name = "CorsiScelti", joinColumns = {
        @JoinColumn(name = "fk_materia", referencedColumnName = "codice")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_studente", referencedColumnName = "matricola")})
    @ManyToMany
    private Collection<Studente> studenteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkMateria")
    private Collection<Appello> appelloCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
    private Collection<EsamiSvolti> esamiSvoltiCollection;

    public Materia() {
    }

    public Materia(String codice) {
        this.codice = codice;
    }

    public Materia(String codice, String nome, Date anno, int cfu, String tipoCfu, int semestre) {
        this.codice = codice;
        this.nome = nome;
        this.anno = anno;
        this.cfu = cfu;
        this.tipoCfu = tipoCfu;
        this.semestre = semestre;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getAnno() {
        return anno;
    }

    public void setAnno(Date anno) {
        this.anno = anno;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public String getTipoCfu() {
        return tipoCfu;
    }

    public void setTipoCfu(String tipoCfu) {
        this.tipoCfu = tipoCfu;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @XmlTransient
    public Collection<Professore> getProfessoreCollection() {
        return professoreCollection;
    }

    public void setProfessoreCollection(Collection<Professore> professoreCollection) {
        this.professoreCollection = professoreCollection;
    }

    @XmlTransient
    public Collection<CorsoDiLaurea> getCorsoDiLaureaCollection() {
        return corsoDiLaureaCollection;
    }

    public void setCorsoDiLaureaCollection(Collection<CorsoDiLaurea> corsoDiLaureaCollection) {
        this.corsoDiLaureaCollection = corsoDiLaureaCollection;
    }

    @XmlTransient
    public Collection<Studente> getStudenteCollection() {
        return studenteCollection;
    }

    public void setStudenteCollection(Collection<Studente> studenteCollection) {
        this.studenteCollection = studenteCollection;
    }

    @XmlTransient
    public Collection<Appello> getAppelloCollection() {
        return appelloCollection;
    }

    public void setAppelloCollection(Collection<Appello> appelloCollection) {
        this.appelloCollection = appelloCollection;
    }

    @XmlTransient
    public Collection<EsamiSvolti> getEsamiSvoltiCollection() {
        return esamiSvoltiCollection;
    }

    public void setEsamiSvoltiCollection(Collection<EsamiSvolti> esamiSvoltiCollection) {
        this.esamiSvoltiCollection = esamiSvoltiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codice != null ? codice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gid.myunivaq2.rest.Materia[ codice=" + codice + " ]";
    }
    
}
