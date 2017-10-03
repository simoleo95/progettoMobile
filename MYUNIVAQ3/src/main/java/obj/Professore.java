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
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ASUS TRONY
 */
public class Professore {
    private int id ;
    private String nome ;
    private String cognome;
    private String data ="";

    public Professore() {
    }

    public Professore(int id, String nome, String cognome, String data) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public void save(){
    //controlla se esiste , modifica o crea;
    }
    
    public void Load(int i) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   "from  MYUNIVAQ.Professore "+
                    "WHERE Professore.id =" +i ;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            
        
            
            this.data = rs.getString("dataDiNascita");
            this.id = rs.getInt("id");
            this.nome = rs.getString("nome");
            this.cognome = rs.getString("cognome");
            
            
            
            }
        
        
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
    }
}
