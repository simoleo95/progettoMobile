package gid.myunivaq2.jpa;

import gid.myunivaq2.jpa.CorsoDiLaurea;
import gid.myunivaq2.jpa.EsamiSvolti;
import gid.myunivaq2.jpa.Materia;
import gid.myunivaq2.jpa.Tassa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-09-12T18:32:56")
@StaticMetamodel(Studente.class)
public class Studente_ { 

    public static volatile SingularAttribute<Studente, String> cognome;
    public static volatile SingularAttribute<Studente, CorsoDiLaurea> corso;
    public static volatile CollectionAttribute<Studente, EsamiSvolti> esamiSvoltiCollection;
    public static volatile CollectionAttribute<Studente, Materia> materiaCollection;
    public static volatile SingularAttribute<Studente, String> nome;
    public static volatile CollectionAttribute<Studente, Tassa> tassaCollection;
    public static volatile SingularAttribute<Studente, Integer> matricola;
    public static volatile SingularAttribute<Studente, Date> dataDiNascita;

}