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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ASUS TRONY
 */
public class Studente {
    private int matricola ;
    private String nome;
    private String cognome;
    private String dataDiNascita;
    private Corso corso;
    private List<EsamiSvolti> libretto;
    private List<Materia> corsiScelti;
    private List<Tassa> tasse;
    private List<Appello> appelli;
    

    public Studente() {
        this.nome = "qualcosa non va";
    }

    public Studente(int matricola, String nome, String cognome, String dataDiNascita, Corso corso) {
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.corso = corso;
    }

    public List<Appello> getAppelli() {
        return appelli;
    }

    public void setAppelli(List<Appello> appelli) {
        this.appelli = appelli;
    }
    
    public List<Materia> getCorsiScelti() {
        return corsiScelti;
    }

    public void setCorsiScelti(List<Materia> corsiScelti) {
        this.corsiScelti = corsiScelti;
    }
    

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public List<Tassa> getTasse() {
        return tasse;
    }

    public void setTasse(List<Tassa> tasse) {
        this.tasse = tasse;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public List<EsamiSvolti> getLibretto() {
        return libretto;
    }

    public void setLibretto(List<EsamiSvolti> libretto) {
        this.libretto = libretto;
    }
    
    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }
    
    public void Load(int i) throws SQLException{
        
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   " from  MYUNIVAQ.Studente "+
                   " WHERE Studente.matricola =" + i ;
    try {
        
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            this.matricola = rs.getInt("matricola");
            setNome(rs.getString("nome"));
            this.cognome = rs.getString("cognome");
            Date d = rs.getDate("dataDiNascita");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            this.dataDiNascita = df.format(d);
            Corso co = new Corso();
            co.Load(rs.getString("corso"));
            //co.lite();
            setCorso(co);
            }
        
        LoadLibretto(i);
        loadCorsiScelti(i);
         loadTasse(i);
         LoadAppelli();
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
            
    }
    
    
     public void LoadLibretto(int i) throws SQLException{
       
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   "from  MYUNIVAQ.EsamiSvolti "+
                   "WHERE EsamiSvolti.fk_studente = " +i ;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<EsamiSvolti> le = new LinkedList<>();
        while (rs.next()) {
            EsamiSvolti asd = new EsamiSvolti();
            asd.setIdMateria(rs.getString("fk_materia")); 
            System.out.println("aaaaaaaaaaaaaaaaaaa "+rs.getString("fk_materia"));
            asd.setVoto(rs.getInt("voto"));
            Appello ape = new Appello();
            ape.Load(rs.getInt("fk_appello"));
            asd.setAppello(ape);
            asd.setIdStudente(i);
            le.add(asd);
           asd.setMateriaload(rs.getString("fk_materia"));
            }   
        setLibretto(le);
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
            
    }
    
      public void loadCorsiScelti(int i) throws SQLException{
       
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   "from  MYUNIVAQ.CorsiScelti "+
                   "WHERE CorsiScelti.fk_studente =" +i ;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<Materia> lm = new LinkedList<>();
        while (rs.next()) {
            Materia ma = new Materia();
            ma.Load(rs.getString("fk_materia"));
            lm.add(ma);
           
            } 
        setCorsiScelti(lm);
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
            
    }
    
       public void loadTasse(int i) throws SQLException{
       
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = "select * " +
                   "from  MYUNIVAQ.Tassa "+
                   "WHERE Tassa.studente_fk =" +i ;
    try {
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<Tassa> lt = new LinkedList<>();
        while (rs.next()) {
            Tassa tas = new Tassa();
            tas.Load(rs.getString("id"));
            lt.add(tas);
            
            }   
        setTasse(lt);
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
            
    }
    
        public void LoadAppelli() throws SQLException{
           List<String> mancanti = new ArrayList<>();
            List<String> mancanti2 = new ArrayList<>();
           List<String> svolti = new ArrayList<>();
            for (Iterator<EsamiSvolti> iterator = libretto.iterator(); iterator.hasNext();) {
                String next = iterator.next().getIdMateria();
                svolti.add(next);
            }
            for (Iterator<Materia> iterator2 = this.corso.getMaterie().iterator(); iterator2.hasNext();) {
                String next = iterator2.next().getId();
                mancanti.add(next);
            }
            for (Iterator<Materia> iterator3 = this.corsiScelti.iterator(); iterator3.hasNext();) {
                String next = iterator3.next().getId();
                mancanti.add(next);
            }
            mancanti2.addAll(mancanti);
        for (String next : mancanti2) {
               for (String next2 :  svolti) {
                   if(next.equals(next2)){
                        System.out.println(next +"  = "+ next2);
                       mancanti.remove(next);
                       break;
                   }
               }
        }
         for (String next2 :  mancanti) {
                   
                        System.out.println("manca = "+ next2);
                      
                   }
        
        List<Appello> la = new LinkedList<>();
        for (String next2 : mancanti) {
            Appello a = new Appello();
           boolean x = a.appellidata2(next2);
            if (x) la.add(a);
            
        }
         this.setAppelli(la);
         
    }
         
        public boolean iscriviti (int appello) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
        boolean i = false;
    String query = "INSERT INTO `MYUNIVAQ`.`iscrizione` (`fk_studente`, `fk_appello`) VALUES ('"+this.matricola+"', '"+appello+"')";
    System.out.println("INSERT INTO `MYUNIVAQ`.`iscrizione` (`fk_studente`, `fk_appello`) VALUES ('"+this.matricola+"', '"+appello+"')");
    try{
        
       stmt = con.createStatement();
       int rs = stmt.executeUpdate(query);
        i = rs > 0;
       
      
            
        
        }catch(SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
        
        return i;
    }
        
        public List<Appello> appelliiscritti() throws SQLException{
            List<Appello> a = new LinkedList<>();
         
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
        int i =0;
    String query = "select * " +
                   " from  MYUNIVAQ.iscrizione "+
                    " WHERE iscrizione.fk_studente = " + this.matricola ;
    try{
        
         stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
           int appello= rs.getInt("fk_appello");
           Appello app= new Appello();
           app.Load(appello);
           a.add(app);  
        }
    
    }catch(SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
       
            return a;
        }
        
        
        
        
        public List<Orario> orariopersonale()throws SQLException{
            List<Orario> a = new LinkedList<>();
             List<Orario> out = new LinkedList<>();
               Corso cor =this.getCorso();
           List<Materia> materie = cor.getMaterie();
           List<Materia> tutti = this.getCorsiScelti();
                   tutti.addAll(materie);
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
        int i =0;
    String query = "select * " +
                   "from  MYUNIVAQ.Orario ";
    try{
        
         stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
        Orario o = new Orario();
        o.load(rs.getInt("id"));
        a.add(o);
        }
        
    }catch(SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
       
            for (Orario orario : a) {
                for (Materia mat : tutti) {
                     if( orario.getMateria().getId().equals(mat.getId()) ){
                         out.add(orario);
                }
                }
                
            }
    
            return out;
        }
    }
     