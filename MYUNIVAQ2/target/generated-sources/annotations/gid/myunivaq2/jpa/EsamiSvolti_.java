package gid.myunivaq2.jpa;

import gid.myunivaq2.jpa.Appello;
import gid.myunivaq2.jpa.EsamiSvoltiPK;
import gid.myunivaq2.jpa.Materia;
import gid.myunivaq2.jpa.Studente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T18:27:35")
@StaticMetamodel(EsamiSvolti.class)
public class EsamiSvolti_ { 

    public static volatile SingularAttribute<EsamiSvolti, Integer> voto;
    public static volatile SingularAttribute<EsamiSvolti, Appello> fkAppello;
    public static volatile SingularAttribute<EsamiSvolti, Materia> materia;
    public static volatile SingularAttribute<EsamiSvolti, Studente> studente;
    public static volatile SingularAttribute<EsamiSvolti, EsamiSvoltiPK> esamiSvoltiPK;

}