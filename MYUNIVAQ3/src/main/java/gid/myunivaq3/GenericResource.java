/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq3;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import obj.Appello;
import obj.Aula;
import obj.Corso;
import obj.Domanda;
import obj.Login;
import obj.Materia;
import obj.Orario;
import obj.Professore;
import obj.Questionario;
import obj.Studente;

/**
 * REST Web Service
 *
 * @author ASUS TRONY
 */
@Path("generic")
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
    @Path("corso/{corso}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response findmatricolaa(@PathParam("corso") String a) throws SQLException {    
     Corso c = new Corso();
      c.Load(a);
      
//        List<Materia> materie = c.getMaterie();
//        for (Materia materia : materie) {
//            materia.lite();
//            
//        }
//        c.setMaterie(materie);
      c.lite();
       return Response.ok(c).build();
    }
   @GET
    @Path("materia/{materia}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response materiaid(@PathParam("materia") String a) throws SQLException {    
       
      Materia m = new Materia();
      m.Load(a);
      m.lite2();
      
     
       return Response.ok(m).build();
    }
    
    @GET
    @Path("professore/{professore}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response professore(@PathParam("professore") int a) throws SQLException {    
      Professore p = new Professore();
      p.Load(a);
      return Response.ok(p).build();
    }
    
    @GET
    @Path("appello/{appello}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response appello(@PathParam("appello") int a) throws SQLException {    
      
      Appello ap = new Appello();
      ap.Load(a);
       return Response.ok(ap).build();
    }
    
    @GET
    @Path("{appello}/iscritti")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response iscrittiappello(@PathParam("appello") int a) throws SQLException {    
      
      Appello ap = new Appello();
      ap.Load(a);
      int iscritti = ap.quantiIscritti();
       return Response.ok(iscritti).build();
    }
      @GET
    @Path("aula/{aula}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response aula(@PathParam("aula") String a) throws SQLException {    
      Aula au = new Aula();
      au.Load(a);
       return Response.ok(au).build();
    }
    
      @GET
    @Path("aule_libere")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<Aula> aulelibere() throws SQLException {
        
        Orario o = new Orario();
       
        return o.aulelibere();
    }
    
    
     @POST
    @Path("questionariosalva")
    @Produces({ MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public Questionario prova(Questionario quest) throws SQLException {
        
     
       String p = "MYUNIVAQ3\\questionari\\"+quest.getStudente()+"_"+ quest.getMateria() +"_"+ quest.getProf() +".json" ;  
       Questionario q = new Questionario(quest.getStudente(), quest.getMateria(), quest.getProf(),p , quest.getQuestionario());
       q.salva();
       return q;
    }
}
