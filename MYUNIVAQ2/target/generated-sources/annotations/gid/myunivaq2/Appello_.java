package gid.myunivaq2;

import gid.myunivaq2.Aula;
import gid.myunivaq2.Esamisvolti;
import gid.myunivaq2.Materia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T17:47:27")
@StaticMetamodel(Appello.class)
public class Appello_ { 

    public static volatile CollectionAttribute<Appello, Esamisvolti> esamisvoltiCollection;
    public static volatile SingularAttribute<Appello, String> descrizione;
    public static volatile SingularAttribute<Appello, Aula> aula;
    public static volatile SingularAttribute<Appello, Date> dataEsame;
    public static volatile SingularAttribute<Appello, Materia> fkMateria;
    public static volatile SingularAttribute<Appello, Integer> id;
    public static volatile CollectionAttribute<Appello, Esamisvolti> esamisvoltiCollection1;

}