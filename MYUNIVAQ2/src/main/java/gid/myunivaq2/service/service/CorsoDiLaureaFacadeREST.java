/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.service.service;

import SPARTA.PianoDiStudi;
import gid.myunivaq2.jpa.CorsoDiLaurea;
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
@Path("corsodilaurea")
public class CorsoDiLaureaFacadeREST extends AbstractFacade<CorsoDiLaurea> {

    @PersistenceContext(unitName = "GID_MYUNIVAQ2_war_2.0esamePU")
    private EntityManager em;

    public CorsoDiLaureaFacadeREST() {
        super(CorsoDiLaurea.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(CorsoDiLaurea entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, CorsoDiLaurea entity) {
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
    public CorsoDiLaurea find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CorsoDiLaurea> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CorsoDiLaurea> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("esamiCorso/{corso}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response findmatricolaa(@PathParam("corso") String a) throws SQLException {  
       
       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MYUNIVAQ?zeroDateTimeBehavior=convertToNull","root","mysql");
       PianoDiStudi asd = new PianoDiStudi();
       List<PianoDiStudi> list = asd.esamicorso(con, a);
       
       return Response.ok(list).build();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
