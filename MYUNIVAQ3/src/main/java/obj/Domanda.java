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
public class Domanda {
    private String domanda;
    private String risposta;

    public Domanda(String domanda, String risposta) {
        this.domanda = domanda;
        this.risposta = risposta;
    }

    public Domanda() {
    }

    public String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

    @Override
    public String toString() {
        return "Domanda{" + "domanda=" + domanda + ", risposta=" + risposta + '}';
    }
    
    
}
