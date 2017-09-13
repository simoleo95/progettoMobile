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
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ASUS TRONY
 */
public class AppelliMatricola {
    
    private int idAppello;
    private String idMateria;
    private String nomeMateria;
    private String descrizione;
    private String data;
    private String aula; 
    private int matricola;
    
    
    public List<AppelliMatricola> listaAppelli(Connection con, int matricola) 
        throws SQLException {
        Statement stmt = null;
        List<AppelliMatricola> C = new ArrayList<>() ;
        String cor = ""  ;
         

                  String query = " SELECT Appello.id ,Appello.fk_materia , Appello.data_esame ,Appello.descrizione , Appello.aula, Materia.nome  "
                 + " FROM Appello "
                          + "JOIN Materia ON Appello.fk_materia = Materia.codice";
                 
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            AppelliMatricola O = new AppelliMatricola();
            O.setAula(rs.getString("aula"));
            Date d = rs.getDate("data_esame");
           SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            O.setData(data);
            O.setDescrizione(rs.getString("descrizione"));
            O.setIdAppello(rs.getInt("id"));
            O.setIdMateria(rs.getString("fk_materia"));
            O.setMatricola(matricola);
            O.setNomeMateria(rs.getString("nome"));
           
           
            C.add(O);
        }
//        LibrettoMatricola lm = new LibrettoMatricola();
//        List<LibrettoMatricola> listLM = lm.LibrettoMatricola(con, Integer.toString(matricola));
//        
//        Iterator<LibrettoMatricola> i = listLM.iterator();
//         
//                             while (i.hasNext()) {
//                                 Iterator<AppelliMatricola> u = C.iterator();
//                                 while(u.hasNext()){
//                                 
//                                 LibrettoMatricola s = i.next();
//                                 AppelliMatricola t =u.next();
//                                 if(s.getMateria().equals(t.getIdMateria())){
//                                 u.remove();
//                                 }
//                                 }}
        
     
    } catch (SQLException e ) {
        
    } finally {
        if (stmt != null ) { stmt.close(); }
    }
        
        
        return C;
    }
    
    

    public AppelliMatricola() {
    }

    public AppelliMatricola(int idAppello, String idMateria, String nomeMateria, String descrizione, String data, String aula, int Matricola) {
        this.idAppello = idAppello;
        this.idMateria = idMateria;
        this.nomeMateria = nomeMateria;
        this.descrizione = descrizione;
        this.data = data;
        this.aula = aula;
        this.matricola = Matricola;
    }

    public int getIdAppello() {
        return idAppello;
    }

    public void setIdAppello(int idAppello) {
        this.idAppello = idAppello;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int Matricola) {
        this.matricola = Matricola;
    }

    @Override
    public String toString() {
        return "AppelliMatricola{" + "idAppello=" + idAppello + ", idMateria=" + idMateria + ", nomeMateria=" + nomeMateria + ", descrizione=" + descrizione + ", data=" + data + ", aula=" + aula + ", Matricola=" + matricola + '}';
    }
    
    
    
    
}
