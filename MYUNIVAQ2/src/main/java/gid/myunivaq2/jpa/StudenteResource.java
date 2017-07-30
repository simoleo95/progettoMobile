/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.jpa;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ASUS TRONY
 */
@Path("Studente")
public class StudenteResource {

   
    @PersistenceContext(unitName = "GID_MYUNIVAQ2_war_2.0esamePU")
    private EntityManager em;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudenteResource
     */
    public StudenteResource() {
    }

    /**
     * Retrieves representation of an instance of gid.myunivaq2.rest.StudenteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudenti() {
        Query q = em.createNamedQuery("Studente.findAll",Studente.class);
        Response.ok(q.getResultList()).build();
        return Response.ok(q.getResultList()).build();
    }
    
    

    /**
     * PUT method for updating or creating an instance of StudenteResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

   
}
