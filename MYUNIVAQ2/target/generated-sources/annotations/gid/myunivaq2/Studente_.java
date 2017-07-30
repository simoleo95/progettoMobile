package gid.myunivaq2;

import gid.myunivaq2.CorsodiLaurea;
import gid.myunivaq2.Esamisvolti;
import gid.myunivaq2.Materia;
import gid.myunivaq2.Tassa;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T17:47:27")
@StaticMetamodel(Studente.class)
public class Studente_ { 

    public static volatile CollectionAttribute<Studente, Esamisvolti> esamisvoltiCollection;
    public static volatile SingularAttribute<Studente, String> cognome;
    public static volatile SingularAttribute<Studente, CorsodiLaurea> corso;
    public static volatile CollectionAttribute<Studente, Materia> materiaCollection;
    public static volatile SingularAttribute<Studente, String> nome;
    public static volatile CollectionAttribute<Studente, Tassa> tassaCollection;
    public static volatile SingularAttribute<Studente, Integer> matricola;
    public static volatile SingularAttribute<Studente, Date> dataDiNascita;

}