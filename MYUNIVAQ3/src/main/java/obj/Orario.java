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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ASUS TRONY
 */
public class Orario {
    private int id ;
    private Materia materia ;
    private String materiaurl;
    private String nomeMateria;
    private String giorno;
    private String oraInizio;
    private String oraFine;
    private Aula aula;
    

    public Orario() {
    }

    public Orario(int id, Materia materia, String giorno, String oraInizio, String oraFine, Aula aula) {
        this.id = id;
        this.materia = materia;
        this.giorno = giorno;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.aula = aula;
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

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getGiorno() {
        return giorno;
    }

    public void setGiorno(String giorno) {
        this.giorno = giorno;
    }

    public String getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(String oraInizio) {
        this.oraInizio = oraInizio;
    }

    public String getOraFine() {
        return oraFine;
    }

    public void setOraFine(String oraFine) {
        this.oraFine = oraFine;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }
    
    public void load (int i)throws SQLException{
        
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = " select * " +
                   " from  MYUNIVAQ.Orario "+
                    " WHERE Orario.id =\'"+ i +"\'" ;
     
    try {
        
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            
            this.id = rs.getInt("id");
            
                    Aula a = new Aula();
                    a.Load(rs.getString("fk_aula"));
                    this.aula = a;
          
            this.giorno =rs.getString("giorno");
            this.oraFine = rs.getString("oraFine");
            this.oraInizio = rs.getString("oraInizio");
            Materia m = new Materia();
            m.Load(rs.getString("fk_materia"));
            this.materia = m;
            }
      
       
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
    
    }
    private String giornodellasettimana() {
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = new Date();
         
        DateFormat format2 = new SimpleDateFormat("EEEE"); 
        String finalDay=format2.format(date);
        System.out.println(finalDay);
        return finalDay;
    }
    private String datadioggi() {
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = new Date();
         
        DateFormat format2 = new SimpleDateFormat("yyyy-mm-dd"); 
        String finalDay=format2.format(date);
        System.out.println(finalDay);
        return finalDay;
    }
     private String orariorio() {
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = new Date();
         
        DateFormat format2 = new SimpleDateFormat("HH:mm:ss"); 
        String finalDay=format2.format(date);
        System.out.println(finalDay);
        return finalDay;
    }
    public List<Aula> aulelibere() throws SQLException{
    List<Aula> out = new LinkedList<>();
    List<Aula> occupate = new LinkedList<>();
     List<Aula> occupateappello = new LinkedList<>();
     String di = this.giornodellasettimana();
     String ora = this.orariorio();
    
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = " select * " +
                   " from  MYUNIVAQ.Orario "+
                    " WHERE Orario.giorno = \'"+ di +"\' "
            + " AND"
            + " oraInizio <= '"+ora+"'  "
            + " AND oraFine >= '"+ora+"' " ;
    
     
                                                           
        System.out.println(query);
    try {
        
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        //aule occupate 
        while (rs.next()) {
            Aula au = new Aula();
            au.Load(rs.getString("fk_aula"));
            System.out.println("ci siamo");
            occupate.add(au); 
            }
        Aula asd = new Aula();
      out = asd.tutte();
      occupateappello = this.auleoccupatedagliappelli();
//      fare la sottrazione tra out - occupate ;
        for (Aula aula1 : occupate) {
             
            for (Aula aula2 : out) {
                if(aula1.getId().equals(aula2.getId())){
                out.remove(aula2);
                }
                
            }
            
        }
         for (Aula aula1 : occupateappello) {
              for (Aula aula2 : out) {
                if(aula1.getId().equals(aula2.getId())){
                out.remove(aula2);
                }
            }
            
        }
      
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
    
    
    
    
    return out;
    }
    
    
      public List<Aula> auleoccupatedagliappelli() throws SQLException{ 
    List<Aula> occupate = new LinkedList<>();
     String di = this.datadioggi();
     String ora = this.orariorio();
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = " select aula " +
                   " from  MYUNIVAQ.Appello "+
                    " WHERE Appello.data_esame = \'"+ di +"\' "
            + " AND"
            + " oraInizio <= '"+ora+"'  "
            + " AND oraFine >= '"+ora+"' " ;
    
                                                           
        System.out.println(query);
    try {
        
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        //aule occupate 
        while (rs.next()) {
            Aula au = new Aula();
            au.Load(rs.getString("aula"));
            occupate.add(au); 
            }
       
            
        
      
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
    
    
    
    
    return occupate;
    }

    public void lite() {
        this.materiaurl= "http://localhost:8088/MYUNIVAQ3/rest/generic/materia/"+this.materia.getId();
        this.nomeMateria = this.materia.getNome();
        this.materia = null;
    }
    
}
