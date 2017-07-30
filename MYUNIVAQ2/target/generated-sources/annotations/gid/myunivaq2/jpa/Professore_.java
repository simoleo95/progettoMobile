package gid.myunivaq2.jpa;

import gid.myunivaq2.jpa.Materia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T18:27:35")
@StaticMetamodel(Professore.class)
public class Professore_ { 

    public static volatile SingularAttribute<Professore, String> cognome;
    public static volatile CollectionAttribute<Professore, Materia> materiaCollection;
    public static volatile SingularAttribute<Professore, String> nome;
    public static volatile SingularAttribute<Professore, Integer> id;
    public static volatile SingularAttribute<Professore, Date> dataDiNascita;

}