package gid.myunivaq2;

import gid.myunivaq2.Studente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T17:47:27")
@StaticMetamodel(Tassa.class)
public class Tassa_ { 

    public static volatile SingularAttribute<Tassa, String> descrizione;
    public static volatile SingularAttribute<Tassa, Integer> costo;
    public static volatile SingularAttribute<Tassa, Studente> studenteFk;
    public static volatile SingularAttribute<Tassa, String> nome;
    public static volatile SingularAttribute<Tassa, String> id;
    public static volatile SingularAttribute<Tassa, Boolean> pagata;
    public static volatile SingularAttribute<Tassa, Date> dataScadenza;

}