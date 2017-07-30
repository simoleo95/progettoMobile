package gid.myunivaq2.jpa;

import gid.myunivaq2.jpa.Aula;
import gid.myunivaq2.jpa.EsamiSvolti;
import gid.myunivaq2.jpa.Materia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T18:27:35")
@StaticMetamodel(Appello.class)
public class Appello_ { 

    public static volatile SingularAttribute<Appello, String> descrizione;
    public static volatile SingularAttribute<Appello, Aula> aula;
    public static volatile CollectionAttribute<Appello, EsamiSvolti> esamiSvoltiCollection;
    public static volatile SingularAttribute<Appello, Date> dataEsame;
    public static volatile SingularAttribute<Appello, Materia> fkMateria;
    public static volatile SingularAttribute<Appello, Integer> id;

}