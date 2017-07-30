package gid.myunivaq2.jpa;

import gid.myunivaq2.jpa.Materia;
import gid.myunivaq2.jpa.Studente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T18:27:35")
@StaticMetamodel(CorsoDiLaurea.class)
public class CorsoDiLaurea_ { 

    public static volatile SingularAttribute<CorsoDiLaurea, String> descrizione;
    public static volatile CollectionAttribute<CorsoDiLaurea, Studente> studenteCollection;
    public static volatile CollectionAttribute<CorsoDiLaurea, Materia> materiaCollection;
    public static volatile SingularAttribute<CorsoDiLaurea, String> nome;
    public static volatile SingularAttribute<CorsoDiLaurea, String> id;

}