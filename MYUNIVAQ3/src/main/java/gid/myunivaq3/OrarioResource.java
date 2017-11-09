/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq3;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import obj.Aula;
import obj.Orario;

/**
 * REST Web Service
 *
 * @author ASUS TRONY
 */
@Path("orario")
public class OrarioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OrarioResource
     */
    public OrarioResource() {
    }

    /**
     * Retrieves representation of an instance of gid.myunivaq3.OrarioResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aula> prova() throws SQLException {
        
        Orario o = new Orario();
       
        return o.aulelibere();
    }

    /**
     * PUT method for updating or creating an instance of OrarioResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
