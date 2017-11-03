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

/**
 *
 * @author ASUS TRONY
 */
public class Iscrizione {
    private Appello a;
    private int matricola;

    public Iscrizione() {
    }

    public Iscrizione(Appello a, int matricola) {
        this.a = a;
        this.matricola = matricola;
    }

    public Appello getA() {
        return a;
    }

    public void setA(Appello a) {
        this.a = a;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }
    
    public int quantiInscritti (int appello) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
        int i =0;
    String query = "select * " +
                   " from  MYUNIVAQ.iscrizione "+
                    " WHERE iscrizione.fk_appello = " + appello ;
    try{
        
         stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
           i++;
            
        }
    
    }catch(SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
        return i;
    }
    
     public boolean iscriviti (int matricola ,int appello) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
        boolean i =false;
    String query = " INSERT INTO MYUNIVAQ.iscrizione (fk_studente , fk_appello) "
            + "VALUES ("+matricola+", "+appello+")";
    try{
        
         stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        i = rs != null;
       
    
    }catch(SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
        return i;
    }
}
