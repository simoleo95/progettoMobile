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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ASUS TRONY
 * 
 */
public class Materia {
    
    private String id ;
    private String nome;
    private int anno;
    private int semestre;
    private int cfu;
    private String tipocfu;
    private List<Professore> professori ;
    private List<String> profurl;
    public Materia() {
    }

    public Materia(String id, String nome, int anno, int semestre, int cfu, String tipocfu) {
        this.id = id;
        this.nome = nome;
        this.anno = anno;
        this.semestre = semestre;
        this.cfu = cfu;
        this.tipocfu = tipocfu;
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

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public String getTipocfu() {
        return tipocfu;
    }

    public void setTipocfu(String tipocfu) {
        this.tipocfu = tipocfu;
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nome=" + nome + ", anno=" + anno + ", semestre=" + semestre + ", cfu=" + cfu + ", tipocfu=" + tipocfu + '}';
    }

    public List<Professore> getProfessori() {
        return professori;
    }

    public void setProfessori(List<Professore> professori) {
        this.professori = professori;
    }

    public List<String> getProfurl() {
        return profurl;
    }

    public void setProfurl(List<String> profurl) {
        this.profurl = profurl;
    }
    
    public void addProfessore(int i ,LinkedList<Professore> lp) throws SQLException {
        Professore asd = new Professore();
        asd.Load(i);
        lp.add(asd);
        setProfessori(lp);
   
       
    }
     public void addProfessoreurl(int i ,LinkedList<String> lp) throws SQLException {
        String asd = "http://localhost:8088/MYUNIVAQ3/rest/generic/professore/"+i;
        
        lp.add(asd);
        setProfurl(lp);
   
       
    }
       
    public void Load(String i) throws SQLException{
        
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = " select * " +
                   " from  MYUNIVAQ.Materia "+
                    " WHERE Materia.codice =\'"+ i +"\'" ;
     
    try {
        
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            
            this.id = rs.getString("codice");
            this.nome = rs.getString("nome");
          
            this.anno =rs.getInt("anno");
            this.semestre = rs.getInt("semestre");
            this.cfu = rs.getInt("cfu");
            this.tipocfu = rs.getString("tipoCfu");
            }
       LoadProfessori();
       
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
            
    }
    
    public void LoadProfessori() throws SQLException{
    if (this.id != null){
        
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   "from  MYUNIVAQ.insegnamento "+
                   "WHERE insegnamento.fk_materia = \'" + this.id +"\'" ;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
         List<Professore> lp = new LinkedList<>();
         List<String> lp2 = new LinkedList<>();
        while (rs.next()) {
           
           addProfessore(rs.getInt("fk_professore"), (LinkedList<Professore>) lp);
            addProfessoreurl(rs.getInt("fk_professore"), (LinkedList<String>) lp2);
          }
        
        
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
         
    }
}
    

public void lite(){
        this.professori =null;
                this.id =null;
        
                              
}
public void lite2(){
        this.professori =null;
               
}
}