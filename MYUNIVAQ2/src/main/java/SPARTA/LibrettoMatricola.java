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
public class LibrettoMatricola {
    private int matricola;
    private String materia ;
    private String nomeMateria;
    private int voto;
    private String dataappello;
    private int appello;

    @Override
    public String toString() {
        return "LibrettoMatricola{" + "Matricola=" + matricola + ", Materia=" + materia + ", nomeMateria=" + nomeMateria + ", voto=" + voto + ", dataappello=" + dataappello + ", appello=" + appello + '}';
    }

     public List<LibrettoMatricola> LibrettoMatricola(Connection con, String matricola) 
        throws SQLException {
        Statement stmt = null;
        List<LibrettoMatricola> C = new ArrayList<>() ;
        
         
         String query = "SELECT EsamiSvolti.fk_materia ,EsamiSvolti.fk_studente ,EsamiSvolti.voto ,EsamiSvolti.fk_appello ,"+
                 " Materia.nome AS nomemateria ,"+
                 " Appello.data_esame AS data "+
                        " FROM `EsamiSvolti` "+
                        " JOIN Materia ON EsamiSvolti.fk_materia = Materia.codice "+
                        "JOIN Studente ON EsamiSvolti.fk_studente =Studente.matricola "+
                        "JOIN Appello ON EsamiSvolti.fk_appello = Appello.id "+
                        " WHERE EsamiSvolti.fk_studente ="+ matricola;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
           LibrettoMatricola O = new LibrettoMatricola();
           
           
           
            O.setMatricola(rs.getInt("fk_studente"));
            O.setMateria(rs.getString("fk_materia"));
            O.setNomeMateria(rs.getString("nomemateria"));
            O.setVoto(rs.getInt("voto"));   
           Date d = rs.getDate("data");
           SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            O.setDataappello(df.format(d));
            O.setAppello(rs.getInt("fk_appello"));
           C.add(O);
        }
       
       
    } catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
        
        return C;
    }
    
    public LibrettoMatricola() {
    }

    public LibrettoMatricola(int Matricola, String Materia, int voto, int appello) {
        this.matricola = Matricola;
        this.materia = Materia;
        this.voto = voto;
        this.appello = appello;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNomeMateria() {
        return nomeMateria;
    }

    public void setNomeMateria(String nomeMateria) {
        this.nomeMateria = nomeMateria;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public String getDataappello() {
        return dataappello;
    }

    public void setDataappello(String dataappello) {
        this.dataappello = dataappello;
    }

    public int getAppello() {
        return appello;
    }

    public void setAppello(int appello) {
        this.appello = appello;
    }
    
    
    
}
