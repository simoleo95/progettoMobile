/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq3;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import obj.Login;

/**
 * REST Web Service
 *
 * @author ASUS TRONY
 */
@Path("login")
public class LoginResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    /**
     * Retrieves representation of an instance of gid.myunivaq3.LoginResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @PUT
    @Path("new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String Crea(Login log) throws SQLException{
        
        
        int i =    log.crea();
        System.out.println(i);
        if(i>0){
            return "ok";
        }else{
            return "errore";
        }
        
    }
    
    //verifica user e psw e restituisce il nuovo token 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Login Login(Login log) {
     Login out = new Login();
        try {
            out = log.loginn(log.getUser(), log.getPsw());
        } catch (SQLException ex) {
            Logger.getLogger(LoginResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out ;
    }
    
    @POST
    @Path("logout")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String Logout(Login log) {
     String out = "error";
        try {
            if( log.logout(log.getUser(), log.getToken())) out ="succes";
        } catch (SQLException ex) {
            Logger.getLogger(LoginResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return out ;
    }
    /**
     * PUT method for updating or creating an instance of LoginResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
