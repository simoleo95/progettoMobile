package gid.myunivaq2.jpa;

import gid.myunivaq2.jpa.Appello;
import gid.myunivaq2.jpa.CorsoDiLaurea;
import gid.myunivaq2.jpa.EsamiSvolti;
import gid.myunivaq2.jpa.Professore;
import gid.myunivaq2.jpa.Studente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T18:27:35")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, Date> anno;
    public static volatile SingularAttribute<Materia, Integer> cfu;
    public static volatile SingularAttribute<Materia, String> tipoCfu;
    public static volatile CollectionAttribute<Materia, EsamiSvolti> esamiSvoltiCollection;
    public static volatile CollectionAttribute<Materia, CorsoDiLaurea> corsoDiLaureaCollection;
    public static volatile CollectionAttribute<Materia, Studente> studenteCollection;
    public static volatile SingularAttribute<Materia, String> codice;
    public static volatile SingularAttribute<Materia, String> nome;
    public static volatile SingularAttribute<Materia, Integer> semestre;
    public static volatile CollectionAttribute<Materia, Professore> professoreCollection;
    public static volatile CollectionAttribute<Materia, Appello> appelloCollection;

}