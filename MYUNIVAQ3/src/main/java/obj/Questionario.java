/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import com.timebuddy.gae.server.service.TokenGenerator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author ASUS TRONY
 */
public class Questionario {
    private String studente;
    private String materia;
    private String prof;
    private String path;
    private List<Domanda> questionario;

    public Questionario() {
    }

    public Questionario(String studente, String materia, String prof, String path) {
        this.studente = studente;
        this.materia = materia;
        this.prof = prof;
        this.path = path;
    }

    public Questionario(String studente, String materia, String prof, String path, List<Domanda> questionario) {
        this.studente = studente;
        this.materia = materia;
        this.prof = prof;
        this.path = path;
        this.questionario = questionario;
    }

    public List<Domanda> getQuestionario() {
        return questionario;
    }

    public void setQuestionario(List<Domanda> questionario) {
        this.questionario = questionario;
    }
    
    public String getStudente() {
        return studente;
    }

    public void setStudente(String studente) {
        this.studente = studente;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    
    public boolean find(String matricola,String materia, String profid)throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
        boolean out = false;
    String query = "select * " +
                   "from  MYUNIVAQ.Questionario "+
                   "WHERE Questionario.fk_materia = \'" + matricola +"\'"
            + " AND"
            + " Questionario.fk_studente =  \'" + materia +"\'"
            + " AND "
            + " Questionario.fk_pro =  \'" + profid +"\'" ;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
         
        while (rs.next()) {
           
        out =true;
          }   
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
    
        return out;
    }
    
    public void salvalocalmente(){
        
//         ObjectMapper mapper = new ObjectMapper();
//          try {  
//              TokenGenerator a = new TokenGenerator();
//              String asd = a.generateToken(this.studente);
//        // Writing to a file   
//        mapper.writeValue(new File("\\questionario\\"+this.studente+"_"+this.materia+"_"+this.prof+".json"), this );

        try(FileWriter file= new FileWriter(this.studente+"_"+this.materia+"_"+this.prof+".json")){
        file.write(this.toString());
        file.flush();
        }catch (IOException e) { 
    }  
        System.out.println(this);
    }
     
}
