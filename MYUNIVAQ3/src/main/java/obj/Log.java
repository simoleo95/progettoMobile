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

/**
 *
 * @author ASUS TRONY
 */
public class Log {

    public Log() {
    }
    
    
    public static boolean Log (String Descrizione  ,String user ) throws SQLException{
        boolean out = false ;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date date = new Date();
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
        Statement stmt = null;
    String query = " INSERT INTO MYUNIVAQ.LOG (Descrizione , Data , fk_user) "
            + "VALUES ('"+Descrizione+"', '"+dateFormat.format(date)+"','"+user+"')";
    System.out.println(dateFormat.format(date));
    try {
        stmt = con.createStatement();
            int rs = stmt.executeUpdate(query);
       
       out = rs > 0;
       
        
    }catch (SQLException e ) {
        
    } finally {
        if (stmt != null) { stmt.close(); }
    }
         return out;
    }
        
    
    }
    

