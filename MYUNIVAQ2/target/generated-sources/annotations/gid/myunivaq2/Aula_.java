package gid.myunivaq2;

import gid.myunivaq2.Appello;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T17:47:27")
@StaticMetamodel(Aula.class)
public class Aula_ { 

    public static volatile SingularAttribute<Aula, String> blocco;
    public static volatile SingularAttribute<Aula, String> id;
    public static volatile CollectionAttribute<Aula, Appello> appelloCollection;

}