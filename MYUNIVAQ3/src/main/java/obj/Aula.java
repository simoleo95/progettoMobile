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
public class Aula {
    private String id ;
    private String blocco;

    public Aula() {
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
    
    public void Load (String i) throws SQLException{
        
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   " from  MYUNIVAQ.Aula "+
                    " WHERE Aula.id = '" +i+"'" ;
    try{
        
         stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            this.id = rs.getString("id");
            this.blocco = rs.getString("blocco");
            
        }
    
    }catch(SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    
}
    
    public List<Aula> tutteperblocco(String blocco) throws SQLException{
         List<Aula> out = new LinkedList<>();
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   " from  MYUNIVAQ.Aula "+
                    " WHERE Aula.blocco = '" +blocco+"'" ;
    try{
        
         stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
              Aula au = new Aula();
           
            au.id = rs.getString("id");
            au.blocco = rs.getString("blocco");
            out.add(au);
        }
    
    }catch(SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    return out;
    }
    
     public List<Aula> tutte() throws SQLException{
         List<Aula> out = new LinkedList<>();
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   " from  MYUNIVAQ.Aula " ;
    try{
        
         stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
              Aula au = new Aula();
           
            au.id = rs.getString("id");
            au.blocco = rs.getString("blocco");
            out.add(au);
        }
    
    }catch(SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    return out;
    }
     
     
   
    }
