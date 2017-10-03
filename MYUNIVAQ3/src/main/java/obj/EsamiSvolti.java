/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

/**
 *
 * @author ASUS TRONY
 */
public class EsamiSvolti {
    
    private int idStudente ;
    private String idMateria;
    private int voto ;
    private Appello appello ;

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
    
    
   
        
    
}
