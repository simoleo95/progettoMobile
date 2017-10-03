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

/**
 *
 * @author ASUS TRONY
 */
public class Tassa {
    
    private String id ;
    private String nome;
    private String datascadenza;
    private String descrizione ;
    private int costo;
    private boolean pagata;

    public Tassa() {
    }

    public Tassa(String id, String nome, String datascadenza, String descrizione, int costo, boolean pagata) {
        this.id = id;
        this.nome = nome;
        this.datascadenza = datascadenza;
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

    public String getDatascadenza() {
        return datascadenza;
    }

    public void setDatascadenza(String datascadenza) {
        this.datascadenza = datascadenza;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public boolean isPagata() {
        return pagata;
    }

    public void setPagata(boolean pagata) {
        this.pagata = pagata;
    }

    public void Load(String i)throws SQLException{
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   "from  MYUNIVAQ.Tassa "+
                    "WHERE Tassa.id =" +i ;
    try{
         stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            this.id = rs.getString("id");
            this.nome = rs.getString("nome");
            Date d = rs.getDate("datascadenza");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            this.datascadenza= df.format(d);
            this.descrizione= rs.getString("descrizione");
            this.costo =rs.getInt("costo");
            this.pagata = rs.getBoolean("pagata");
            
        }
    
    }catch(SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    
}
   
    }
    

