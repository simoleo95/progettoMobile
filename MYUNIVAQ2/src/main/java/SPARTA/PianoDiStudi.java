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
public class PianoDiStudi {
    
    private String id_materia;
    private int matricola;
    private String anno;
    private int semestre;
    private String corso ;
    private String nomeMateria;
    private int cfu;
    
    public List<PianoDiStudi> PianoDiStudi(Connection con, String matricola) 
        throws SQLException {
        Statement stmt = null;
        List<PianoDiStudi> C = new ArrayList<>() ;
        String cor = ""  ;
         

                  String query = " SELECT Studente.corso "
                 + " FROM Studente "
                 + " WHERE Studente.matricola = "+ matricola;
                 
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            cor = rs.getString("corso");
           
        }
        C.addAll(esamicorso(con, cor));
        C.addAll(esamiscelti(con , Integer.parseInt(matricola)));
        for(PianoDiStudi ob : C){
            ob.setMatricola(Integer.parseInt(matricola));
        }
     
    } catch (SQLException e ) {
        
    } finally {
        if (stmt != null ) { stmt.close(); }
    }
        
        
        return C;
    }
    
    

    
     public List<PianoDiStudi> esamicorso(Connection con, String cor) 
        throws SQLException {
        Statement stmt = null;
        List<PianoDiStudi> C = new ArrayList<>() ;
        
         
         String  query = "SELECT MaterieCorso.id_materia , "
                       + "Materia.nome , Materia.anno , Materia.cfu ,Materia.semestre "
                        + " FROM MaterieCorso "
                        + " JOIN Materia ON MaterieCorso.id_Materia = Materia.codice "
                 + " WHERE MaterieCorso.id_corso = "+ cor;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
           PianoDiStudi O = new PianoDiStudi();
            
//           non so perche ma compare due volte Matricola e due volte Materia ! bo !
           Date d = rs.getDate("anno");
           SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");   
          O.setAnno(df.format(d));
          O.setCfu(rs.getInt("cfu"));
          O.setCorso(cor);
          O.setId_materia(rs.getString("id_materia"));
         // O.setMatricola(matricola);
          O.setNomeMateria(rs.getString("nome"));
          O.setSemestre(rs.getInt("semestre"));
           
          
           C.add(O);
        }
       
        
        
       
    } catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
        
        return C;
    }
     
    
        public List<PianoDiStudi> esamiscelti(Connection con, int matricola) 
        throws SQLException {
        Statement stmt = null;
        List<PianoDiStudi> C = new ArrayList<>() ;
        
         
         String  query = "SELECT * "
                        + " FROM CorsiScelti "
                        + " JOIN Materia ON CorsiScelti.fk_materia = Materia.codice "
                 + " WHERE CorsiScelti.fk_studente = "+ matricola;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
           PianoDiStudi O = new PianoDiStudi();
            

           Date d = rs.getDate("anno");
           SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");   
          O.setAnno(df.format(d));
          O.setCfu(rs.getInt("cfu"));
          O.setId_materia(rs.getString("fk_materia"));
          O.setMatricola(rs.getInt("fk_studente"));
          O.setNomeMateria(rs.getString("nome"));
          O.setSemestre(rs.getInt("semestre"));
           
          
           C.add(O);
        }
       
        
        
       
    } catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
        
        return C;
    }
     

    @Override
    public String toString() {
        return "PianoDiStudi{" + "id_materia=" + id_materia + ", matricola=" + matricola + ", anno=" + anno + ", semestre=" + semestre + ", corso=" + corso + ", nomeMateria=" + nomeMateria + ", cfu=" + cfu + '}';
    }
       
       
    
    
    
    
    
    
    
    
    
    
    

    public PianoDiStudi() {
    }

    public PianoDiStudi(String id_materia, int matricola, String anno, int semestre, String corso, String nomeMateria, int cfu) {
        this.id_materia = id_materia;
        this.matricola = matricola;
        this.anno = anno;
        this.semestre = semestre;
        this.corso = corso;
        this.nomeMateria = nomeMateria;
        this.cfu = cfu;
    }

    public String getId_materia() {
        return id_materia;
    }

    public void setId_materia(String id_materia) {
        this.id_materia = id_materia;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getCorso() {
        return corso;
    }

    public void setCorso(String corso) {
        this.corso = corso;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

   
}
