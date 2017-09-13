/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.service.service;

import SPARTA.TassaMatricola;
import gid.myunivaq2.jpa.Tassa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ASUS TRONY
 */
@Stateless
@Path("tassa")
public class TassaFacadeREST extends AbstractFacade<Tassa> {

    @PersistenceContext(unitName = "GID_MYUNIVAQ2_war_2.0esamePU")
    private EntityManager em;

    public TassaFacadeREST() {
        super(Tassa.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Tassa entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Tassa entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Tassa find(@PathParam("id") String id) {
        return super.find(id);
    }
    
    @GET
    @Path("matricola/{matricola}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response findmatricola(@PathParam("matricola") String a) throws SQLException {  
       
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
       TassaMatricola asd = new TassaMatricola();
       List<TassaMatricola> list = asd.TassaMatricolaC(con, a);
       
       return Response.ok(list).build();
    }
    
    @GET
    @Override
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Tassa> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tassa> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
