/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gid.myunivaq3;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import obj.Appello;
import obj.Corso;
import obj.EsamiSvolti;
import obj.Log;
import obj.Login;
import obj.Materia;
import obj.Orario;
import obj.Studente;
import obj.Tassa;

/**
 * REST Web Service
 *
 * @author ASUS TRONY
 */
@Path("{matricola}")
public class StudenteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StudenteResource
     */
    public StudenteResource() {
    }

    /**
     * Retrieves representation of an instance of gid.myunivaq3.StudenteResource
     * @return an instance of java.lang.String
     */
     @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON})
    public Response tutto(@PathParam("matricola") int a,Login log) throws SQLException {
       if(log.verifica()) {
      Studente s = new Studente();
      s.Load(a); 
       
       return Response.ok(s).build();
       }
       return Response.ok("errore").build();
    }
    
    @POST
    @Path("libretto")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON})
    public Response libretto(@PathParam("matricola") int a,Login log) throws SQLException {
        
       if(log.verifica()) {
      Studente s = new Studente();
      s.Load(a); 
        List<EsamiSvolti> libretto = s.getLibretto();
           for (EsamiSvolti esamiSvolti : libretto) {
               esamiSvolti.lite();
               
           }
       return Response.ok(libretto).build();
       }
       return Response.ok("errore").build();
    }
    
    @POST
    @Path("corsi_a_scelta")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON})
    public Response corsiAScelta(@PathParam("matricola") int a,Login log) throws SQLException {
       if(log.verifica()) {
      Studente s = new Studente();
      s.Load(a); 
        List<Materia> corsiScelti = s.getCorsiScelti();
       return Response.ok(corsiScelti).build();
       }
       return Response.ok("errore").build();
    }
     @POST
    @Path("corso")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON})
    public Response corso(@PathParam("matricola") int a,Login log) throws SQLException {
       if(log.verifica()) {
      Studente s = new Studente();
      s.Load(a); 
           Corso corso = s.getCorso();
           corso.lite();
       return Response.ok(corso).build();
       }
       return Response.ok("errore").build();
    }
    
    @POST
    @Path("tutti_i_corsi")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON})
    public Response tuttiIcorsi(@PathParam("matricola") int a,Login log) throws SQLException {
       if(log.verifica()) {
      Studente s = new Studente();
      s.Load(a); 
           Corso corso = s.getCorso();
           List<Materia> materie = corso.getMaterie();
           List<Materia> corsiScelti = s.getCorsiScelti();
                   corsiScelti.addAll(materie);
                   
                     for (Materia materia : corsiScelti) {
               materia.lite2();
           }
                   
       return Response.ok(corsiScelti).build();
       }
       return Response.ok("errore").build();
    }
    
      @POST
    @Path("tasse")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON})
    public Response tasse(@PathParam("matricola") int a , Login log) throws SQLException {
       if(log.verifica()) {
      Studente s = new Studente();
      s.Load(a); 
           List<Tassa> tasse = s.getTasse();
       return Response.ok(tasse).build();
       }
       return Response.ok("errore").build();
    }
    
      @POST
    @Path("appelli")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON})
    public Response appelli(@PathParam("matricola") int a , Login log) throws SQLException {
       if(log.verifica()) {
      Studente s = new Studente();
      s.Load(a); 
           List<Appello> appelli = s.getAppelli();
       return Response.ok(appelli).build();
       }
       return Response.ok("errore").build();
    }
    @POST
    @Path("appelli/iscritti")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON})
    public Response appelliiscritti(@PathParam("matricola") int a , Login log) throws SQLException {
       if(log.verifica()) {
      Studente s = new Studente();
      s.Load(a); 
           List<Appello> appelli = s.appelliiscritti();
       return Response.ok(appelli).build();
       }
       return Response.ok("errore").build();
    }
    
    @PUT
    @Path("iscrizioneappello/{appello}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.TEXT_PLAIN})
    public String iscriviti(@PathParam("matricola") int a ,@PathParam("appello") int b , Login log) throws SQLException {
       
       if(log.verifica()) {
      Studente s = new Studente();
      s.Load(a); 
      System.out.println("studente caricato");
       if(s.iscriviti(b)){
       if(Log.Log("iscritto all'appello " ,log.getUser())){
      System.out.println("error log");
       }   
       return "iscrizione effettuata con successo";}
       else{
       return "errore nel server";}
       }
       return "errore";
    }
    
    @POST
    @Path("orario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({ MediaType.APPLICATION_JSON})
    public Response orario(@PathParam("matricola") int a , Login log) throws SQLException {
       if(log.verifica()) {
      Studente s = new Studente();
      s.Load(a); 
          List<Orario> out = s.orariopersonale();
           for (Orario orr : out) {
               orr.lite();
           }
       return Response.ok(out).build();
       }
       return Response.ok("errore").build();
    }
}
