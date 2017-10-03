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
    
    
    
    
}
