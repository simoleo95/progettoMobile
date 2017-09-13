/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPARTA;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS TRONY
 */
public class TassaMatricola {
    
    private int id ;
    private String nome;
    private String datascadenza;
    private String descrizione;
    private int costo;
    private boolean pagata;
    private int studente_fk;

    @Override
    public String toString() {
        return "TassaMatricola{" + "id=" + id + ", nome=" + nome + ", datascadenza=" + datascadenza + ", descrizione=" + descrizione + ", costo=" + costo + ", pagata=" + pagata + ", studente_fk=" + studente_fk + '}';
    }

   public void TassaMatricola(Connection con, String matricola)
    throws SQLException {
    
    Statement stmt = null;
    String query = "select * " +
                   "from  MYUNIVAQ.Tassa "+
                    "WHERE Tassa.studente_fk =" +matricola ;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
           
            
            this.setId(rs.getInt("id"));
            this.setNome(rs.getString("Nome"));
            this.setCosto(rs.getInt("costo"));
            this.setDescrizione(rs.getString("descrizione"));
            this.setPagata(rs.getBoolean("costo"));
            Date d = rs.getDate("datascadenza");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            this.setDatascadenza(df.format(d));
            this.setStudente_fk(rs.getInt("studente_fk"));
             
        }
       
       
    } catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
       
}

   
   
    public List<TassaMatricola> TassaMatricolaC(Connection con, String matricola) throws SQLException {
        Statement stmt = null;
        List<TassaMatricola> C = new ArrayList<>() ;
       
    String query = "select * " +
                   "from  MYUNIVAQ.Tassa "+
                    "WHERE Tassa.studente_fk =" +matricola ;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
           TassaMatricola O = new TassaMatricola();
            
            O.setId(rs.getInt("id"));
            O.setNome(rs.getString("Nome"));
            O.setCosto(rs.getInt("costo"));
            O.setDescrizione(rs.getString("descrizione"));
            O.setPagata(rs.getBoolean("costo"));
            Date d = rs.getDate("datascadenza");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            O.setDatascadenza(df.format(d));
            O.setStudente_fk(rs.getInt("studente_fk"));
           C.add(O);
        }
       
       
    } catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
        
        return C;
    }

    
    
    
    
    
    
    
    public TassaMatricola() {
    }
    
    
    
    public TassaMatricola(int id, String nome, String datascadenza, String descrizione, int costo, boolean pagata, int studente_fk) {
        this.id = id;
        this.nome = nome;
        this.datascadenza = datascadenza;
        this.descrizione = descrizione;
        this.costo = costo;
        this.pagata = pagata;
        this.studente_fk = studente_fk;
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

    public int getStudente_fk() {
        return studente_fk;
    }

    public void setStudente_fk(int studente_fk) {
        this.studente_fk = studente_fk;
    }
    
    
}
