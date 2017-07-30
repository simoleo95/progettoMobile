/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq2.service.service;

import gid.myunivaq2.jpa.EsamiSvolti;
import gid.myunivaq2.jpa.EsamiSvoltiPK;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author ASUS TRONY
 */
@Stateless
@Path("gid.myunivaq2.jpa.esamisvolti")
public class EsamiSvoltiFacadeREST extends AbstractFacade<EsamiSvolti> {

    @PersistenceContext(unitName = "GID_MYUNIVAQ2_war_2.0esamePU")
    private EntityManager em;

    private EsamiSvoltiPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;fkMateria=fkMateriaValue;fkStudente=fkStudenteValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        gid.myunivaq2.jpa.EsamiSvoltiPK key = new gid.myunivaq2.jpa.EsamiSvoltiPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> fkMateria = map.get("fkMateria");
        if (fkMateria != null && !fkMateria.isEmpty()) {
            key.setFkMateria(fkMateria.get(0));
        }
        java.util.List<String> fkStudente = map.get("fkStudente");
        if (fkStudente != null && !fkStudente.isEmpty()) {
            key.setFkStudente(new java.lang.Integer(fkStudente.get(0)));
        }
        return key;
    }

    public EsamiSvoltiFacadeREST() {
        super(EsamiSvolti.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(EsamiSvolti entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, EsamiSvolti entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        gid.myunivaq2.jpa.EsamiSvoltiPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public EsamiSvolti find(@PathParam("id") PathSegment id) {
        gid.myunivaq2.jpa.EsamiSvoltiPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EsamiSvolti> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EsamiSvolti> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
