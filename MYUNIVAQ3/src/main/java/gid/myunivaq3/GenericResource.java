/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq3;

import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import obj.Login;
import obj.Materia;
import obj.Studente;

/**
 * REST Web Service
 *
 * @author ASUS TRONY
 */
@Path("test")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of gid.myunivaq3.GenericResource
     * @return an instance of java.lang.String
     */
   
    
    @GET
    @Path("{matricola}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response findmatricolaa(@PathParam("matricola") int a) throws SQLException {    
      Studente s = new Studente();
      s.Load(a); 
      Materia m = new Materia();
      m.Load("aaa");  
       return Response.ok(s).build();
    }
   @GET
    @Path("materia")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response materiaid(@PathParam("matricola") int a) throws SQLException {    
      Studente s = new Studente();
      s.Load(a); 
      Materia m = new Materia();
      m.Load("aaa");  
       return Response.ok(s).build();
    }
    @GET
    @Path("{user}/{psw}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response corsoid(@PathParam("user") String a,@PathParam("psw") String p) throws SQLException {    
     Login l = new Login();
        Login token = l.loginn(a, p);
       return Response.ok(token).build();
    }
    @GET
    @Path("libretto")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response librettoid(@PathParam("matricola") int a) throws SQLException {    
      Studente s = new Studente();
      s.Load(a); 
      Materia m = new Materia();
      m.Load("aaa");  
       return Response.ok(s).build();
    }
    @GET
    @Path("{corsiscelti}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response corsiscelti(@PathParam("matricola") int a) throws SQLException {    
      Studente s = new Studente();
      s.Load(a); 
      Materia m = new Materia();
      m.Load("aaa");  
       return Response.ok(s).build();
    }
    
}
