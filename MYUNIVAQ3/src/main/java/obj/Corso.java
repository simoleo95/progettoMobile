/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ASUS TRONY
 */
public class Corso {
    private String id;
    private String nome;
    private String descrizione ;
    
    private List<Materia> materie;
    private List<String> materieurl;

    public Corso(String id, String nome, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public List<String> getMaterieurl() {
        return materieurl;
    }

    public void setMaterieurl(List<String> materieurl) {
        this.materieurl = materieurl;
    }

    public Corso() {
        
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

    public List<Materia> getMaterie() {
        return materie;
    }

    public void setMaterie(List<Materia> materie) {
       this.materie = materie;
    }
    
  
    
    public void save(){
    //controlla se esiste , modifica o crea;
    }
    
    
        
    public void addMateria(String i ,LinkedList<Materia> lp) throws SQLException {
        Materia asd = new Materia();
        asd.Load(i);
        lp.add(asd);
        setMaterie(lp);
   
       
    }
     public void addMateria2(String i ,LinkedList<String> lp) throws SQLException {
        String asd = "http://localhost:8088/MYUNIVAQ3/rest/generic/materia/"+i;
        
        lp.add(asd);
        setMaterieurl(lp);
   
       
    }
       
    public void Load(String i) throws SQLException{
        
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   "from  MYUNIVAQ.CorsoDiLaurea "+
                    "WHERE CorsoDiLaurea.id =" +i ;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            this.id = rs.getString("id");
            this.nome = rs.getString("nome");
            this.descrizione = rs.getString("descrizione");
            }
      LoadMaterie();
        
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
            
    }
    
    public void LoadMaterie() throws SQLException{
    if (this.id != null){
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   "from  MYUNIVAQ.MaterieCorso "+
                   "WHERE MaterieCorso.id_corso = " +this.id ;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<Materia> lp = new LinkedList<>();
        List<String> lp2 = new LinkedList<>();
        while (rs.next()) {
            addMateria(rs.getString("id_materia"), (LinkedList<Materia>) lp);
            addMateria2(rs.getString("id_materia"), (LinkedList<String>) lp2);
          }
        setMaterie(lp);
        setMaterieurl(lp2);
        
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
         
    }
}

    public void lite(){
    this.materie = null;
    }
}
