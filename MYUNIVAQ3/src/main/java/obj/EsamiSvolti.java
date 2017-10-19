/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.sql.SQLException;

/**
 *
 * @author ASUS TRONY
 */
public class EsamiSvolti {
    
    private int idStudente ;
    private String idMateria;
    private int voto ;
    private Appello appello ;
    private Materia materia;
    private String materiaurl;
    private String appellourl;

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public void setMateriaload(String materia) {
        try{
             Materia m = new Materia();
             m.Load(materia);
             m.lite();
        this.materia = m;
       
        }catch (SQLException e ) {
        
    }
    }

    public EsamiSvolti() {
    }

    public EsamiSvolti(String idMateria,int idStudente , int voto) {
        this.idMateria = idMateria;
        this.voto = voto;
        this.idStudente = idStudente;
    }

    public int getIdStudente() {
        return idStudente;
    }

    public void setIdStudente(int idStudente) {
        this.idStudente = idStudente;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public Appello getAppello() {
        return appello;
    }

    public void setAppello(Appello appello) {
        this.appello = appello;
    }

    public String getMateriaurl() {
        return materiaurl;
    }

    public void setMateriaurl(String materiaurl) {
        this.materiaurl = materiaurl;
    }

    public String getAppellourl() {
        return appellourl;
    }

    public void setAppellourl(String appellourl) {
        this.appellourl = appellourl;
    }
    
    
   public void lite(){
   this.setMateriaurl("http://localhost:8088/MYUNIVAQ3/rest/generic/materia/"+this.idMateria);
   this.materia=null;
   this.setAppellourl("http://localhost:8088/MYUNIVAQ3/rest/generic/appello/"+this.appello.getId());
   this.appello= null;
   this.idMateria=null;
   }
        
    
}
