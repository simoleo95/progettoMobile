/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author ASUS TRONY
 */
public class Appello {
    private int id ;
    private Materia materia ;
    private String data;
    private String descrizione ;
    private Aula aula;

    public Appello(int id, Materia Materia, String data, String descrizione, Aula aula) {
        this.id = id;
        this.materia = Materia;
        this.data = data;
        this.descrizione = descrizione;
        this.aula = aula;
    }

    public Appello() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia Materia) {
        this.materia = Materia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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
    
    public void Load(int i)throws SQLException{
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   "from  MYUNIVAQ.Appello "+
                    "WHERE Appello.id =" +i ;
    try{
         stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            this.id = rs.getInt("id");
          //  this.materia.Load(rs.getString("fk_materia"));
            Date d = rs.getDate("data_esame");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            setData(df.format(d));
            this.descrizione= rs.getString("descrizione");
          //  this.aula.Load(rs.getString("aula"));
        }
    
    }catch(SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    
}
    
  public boolean appellidata(String i) throws SQLException{
      boolean out = false;
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         java.util.Date date = new java.util.Date();
    String query = "select * " +
                   "from  MYUNIVAQ.Appello "+
                   "WHERE Appello.fk_materia = '" + i +"' AND Appello.data_esame > "+ dateFormat.format(date)  ;
    try{
         System.out.println(query);
         stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            System.out.println("qualcosa");
            out = true;
            this.id = rs.getInt("id");
            Materia m = new Materia();
            m.Load(rs.getString("fk_materia"));
            this.materia = m;
            Date d = rs.getDate("data_esame");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            setData(df.format(d));
            this.descrizione= rs.getString("descrizione");
            Aula a = new Aula();
            a.Load(rs.getString("aula"));
           this.aula =a;
        }
    }catch(SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    
  
  return out;
  
  }
    
    
}
