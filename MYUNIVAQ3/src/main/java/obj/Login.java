/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import com.timebuddy.gae.server.service.TokenGenerator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS TRONY
 */
@XmlRootElement
public class Login {
    
    @XmlElement private String user;
    @XmlElement private String psw;
    @XmlElement private String token;
    @XmlElement private String email;
    @XmlElement private int matricola;

    public Login() {
    }

    public Login(String user, String psw , String email,int matricola) {
        this.user = user;
        this.psw = psw;
        this.email = email;
        this.matricola=matricola;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getMatricla() {
        return matricola;
    }

    public void setMatricla(int matricla) {
        this.matricola = matricla;
    }
    
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String loginn(String user, String psw) throws SQLException{
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
         Statement stmt = null;
         String output = "asd"; 
    String query = " select user , psw  " +
                   " from  MYUNIVAQ.Login "+
                    " WHERE Login.user =\'"+ user +"\'" ;
     
    try {
        
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        String tempu = "";
        String tempp= "";
        while (rs.next()) {
            tempu= rs.getString("user");
            tempp= rs.getString("psw");
            
            }
        if(tempu != null && tempp != null ){
                        output="user inesistente ";
                        if (tempu.equals(user)) { output= "psw errata";
                                                    if (tempp.equals(psw)) {
                                                        TokenGenerator t = new TokenGenerator();                
                                                 output = t.generateToken(user);
                                                 
                                                   // create the java mysql update preparedstatement
                                                        String query2 = "UPDATE  MYUNIVAQ.Login "
                                                                         +" SET token = '"+ output +"' "
                                                                         + " WHERE user = '"+user+"'";
                                                        System.out.println(query2);
                                                        stmt.cancel();
                            int executeUpdate = stmt.executeUpdate(query2);
                                                 System.out.println("risutato query 2===="+ executeUpdate);
                                                 System.out.println(output);
                                                 if(executeUpdate > 0 ){
                                                    
                                                      boolean ok = Log.Log("Login effettuato, modificato il token", user);
                                                      if(ok== false){
                                                      output = "errore Log";
                                                      }
                                                  
                                                 }
                                                 
                                                   
                                                    }
                         }}//end if 
       
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
 
        return output;
    }
    
    public boolean verifica() throws SQLException{
        boolean output = false;
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = " select user , token  " +
                   " from  MYUNIVAQ.Login "+
                    " WHERE Login.user =\'"+ this.user +"\'" ;
     
    try {
        
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        String tempt ="";
        while (rs.next()) {
            tempt= rs.getString("token");
            
            }
        output = (this.token == null ? tempt == null : this.token.equals(tempt));
       
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
            
        //controlla se il token è uguale 
        return output;
    }
    
//    public int crea() throws SQLException{
//        int i = 0;
//          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
//        Statement stmt = null;
//         System.out.println("param1 = " + this.user );
//    System.out.println("param2 = " + this.matricola );
////    String query =  "INSERT INTO MYUNIVAQ.Login (user, psw, email, matricola)"
////            + " VALUES ('"+ this.user +"', '"+ this.psw +"', '"+ this.email +"', "+ this.matricola +" )";
//     String query =  "INSERT INTO MYUNIVAQ.Login (user , psw , email , matricola) "
//            + " VALUES ('qweqwe' , 'qwe' , 'qwe@qwe.qwe' , 111111 )";
//    try {
//        System.out.println("param2 = " + query );
//         stmt = con.createStatement();
//        ResultSet rs = stmt.executeQuery(query);
////        i = stmt.executeUpdate(query);
//        if(rs!= null){
//        i=1;
//        }
//       
//        
//    }catch (SQLException e ) {
//         String r = e.getSQLState();
//         System.out.println("r  = "+ r );
//    } finally {
//        if (stmt != null) { stmt.close(); }
//    }
//            
//        //controlla se il token è uguale se non è ugale ne da uno nuovo senno ristituisce quello vecchio
//        // setta il token e restituisce il token 
//        //aggiungi anche nel db Log che ha fatto un login 
//        
//        //crea un nuovo utente 
//        
//        return i ;
//    }
}
