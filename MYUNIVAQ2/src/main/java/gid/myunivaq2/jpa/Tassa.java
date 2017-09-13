/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.jpa;

import org.codehaus.jackson.annotate.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "Tassa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tassa.findAll", query = "SELECT t FROM Tassa t")
    , @NamedQuery(name = "Tassa.findById", query = "SELECT t FROM Tassa t WHERE t.id = :id")
    , @NamedQuery(name = "Tassa.findBymatricola", query = "SELECT t FROM Tassa t  WHERE t.studenteFk.matricola = :matricola")
    , @NamedQuery(name = "Tassa.findByNome", query = "SELECT t FROM Tassa t WHERE t.nome = :nome")
    , @NamedQuery(name = "Tassa.findByDataScadenza", query = "SELECT t FROM Tassa t WHERE t.dataScadenza = :dataScadenza")
    , @NamedQuery(name = "Tassa.findByCosto", query = "SELECT t FROM Tassa t WHERE t.costo = :costo")
    , @NamedQuery(name = "Tassa.findByPagata", query = "SELECT t FROM Tassa t WHERE t.pagata = :pagata")})
public class Tassa implements Serializable {

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
    @Column(name = "Nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datascadenza")
    @Temporal(TemporalType.DATE)
    private Date dataScadenza;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descrizione")
    private String descrizione;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    @JsonIgnore
    private int costo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pagata")
    private boolean pagata;
    @JoinColumn(name = "studente_fk", referencedColumnName = "matricola")
    @ManyToOne(optional = false)
    @JsonBackReference
    @JsonProperty(access = Access.WRITE_ONLY)
    private Studente studenteFk;
    
    public Tassa() {
    }

    public Tassa(String id) {
        this.id = id;
    }

    public Tassa(String id, String nome, Date dataScadenza, String descrizione, int costo, boolean pagata) {
        this.id = id;
        this.nome = nome;
        this.dataScadenza = dataScadenza;
        this.descrizione = descrizione;
        this.costo = costo;
        this.pagata = pagata;
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

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    @JsonIgnore
    public int getCosto() {
        return costo;
    }
    @JsonIgnore
    public void setCosto(int costo) {
        this.costo = costo;
    }

    public boolean getPagata() {
        return pagata;
    }

    public void setPagata(boolean pagata) {
        this.pagata = pagata;
    }
    
    @XmlTransient
     @JsonIgnore
    public Studente getStudenteFk() {
        return studenteFk;
    }
    @XmlTransient
    @JsonProperty
    public void setStudenteFk(Studente studenteFk) {
        this.studenteFk = studenteFk;
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
        if (!(object instanceof Tassa)) {
            return false;
        }
        Tassa other = (Tassa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gid.myunivaq2.rest.Tassa[ id=" + id + " ]";
    }
    
}
