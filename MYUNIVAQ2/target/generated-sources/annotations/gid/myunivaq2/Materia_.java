package gid.myunivaq2;

import gid.myunivaq2.Appello;
import gid.myunivaq2.CorsodiLaurea;
import gid.myunivaq2.Esamisvolti;
import gid.myunivaq2.Professore;
import gid.myunivaq2.Studente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T17:47:27")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile CollectionAttribute<Materia, Esamisvolti> esamisvoltiCollection;
    public static volatile SingularAttribute<Materia, Date> anno;
    public static volatile SingularAttribute<Materia, Integer> cfu;
    public static volatile SingularAttribute<Materia, String> tipoCfu;
    public static volatile CollectionAttribute<Materia, CorsodiLaurea> corsodiLaureaCollection;
    public static volatile CollectionAttribute<Materia, Studente> studenteCollection;
    public static volatile SingularAttribute<Materia, String> codice;
    public static volatile SingularAttribute<Materia, Integer> nome;
    public static volatile SingularAttribute<Materia, Integer> semestre;
    public static volatile CollectionAttribute<Materia, Professore> professoreCollection;
    public static volatile CollectionAttribute<Materia, Appello> appelloCollection;

}