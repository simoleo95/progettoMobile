/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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

    @Override
    public String toString() {
//        String quest= "";
//        for (Domanda domanda : questionario) {
//            quest= quest + domanda.toString();
//        }
        return "Questionario{" + "studente=" + studente + ", materia=" + materia + ", prof=" + prof + ", path=" + path + ", questionario=" + questionario + '}';
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
    
    public String salva() throws SQLException{
        boolean out = false;
    if(find(this.studente, this.materia, this.prof)){
        System.err.println("esiste gia salvata");
    return "esiste gia salvata";
    }else{
        if(salvalocalmente()){
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
        
    String query =" INSERT INTO `MYUNIVAQ`.`Questionario` (`path`, `fk_studente`, `fk_materia`, `fk_pro`) VALUES ('"+ this.path +"','"+this.studente +"','"+this.materia +"','"+this.prof +"')";
    try {
        stmt = con.createStatement();
            int rs = stmt.executeUpdate(query);
       
       out = rs > 0;
         boolean ok = Log.Log("Salvataggio questionario,"+this.studente+"_"+this.materia+"_"+this.prof , this.studente);
                                                      if(ok== false){
                                                      System.out.println("error log");
                                                      }
             
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        }
        System.err.println("stato: "+out);
        
        return "stato: "+out;
    }
    
    }
    
    
    
    
   

    
    public boolean salvalocalmente(){
        boolean out = false ;
                String fullpath = null;
                File f = new File("..\\..\\MYUNIVAQ3\\questionari\\", this.studente+"_"+this.materia+"_"+this.prof+".json");
               

                try(FileWriter file= new FileWriter(f)){
                file.write(this.toString());
                file.flush();
                out = true;
                System.out.println("qualcosa è susccessio  "+this.studente+"_"+this.materia+"_"+this.prof+".json");
                }catch (IOException e) { 
            }  
                System.out.println(this.toString());
                return out ;
            }

    }

