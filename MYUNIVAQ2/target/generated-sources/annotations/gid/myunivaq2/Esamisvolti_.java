package gid.myunivaq2;

import gid.myunivaq2.Appello;
import gid.myunivaq2.EsamisvoltiPK;
import gid.myunivaq2.Materia;
import gid.myunivaq2.Studente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T17:47:27")
@StaticMetamodel(Esamisvolti.class)
public class Esamisvolti_ { 

    public static volatile SingularAttribute<Esamisvolti, Integer> voto;
    public static volatile SingularAttribute<Esamisvolti, Appello> data;
    public static volatile SingularAttribute<Esamisvolti, Appello> fkAppello;
    public static volatile SingularAttribute<Esamisvolti, EsamisvoltiPK> esamisvoltiPK;
    public static volatile SingularAttribute<Esamisvolti, Materia> materia;
    public static volatile SingularAttribute<Esamisvolti, Studente> studente;

}