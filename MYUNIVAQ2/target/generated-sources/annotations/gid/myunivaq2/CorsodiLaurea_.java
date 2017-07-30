package gid.myunivaq2;

import gid.myunivaq2.Materia;
import gid.myunivaq2.Studente;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-29T17:47:27")
@StaticMetamodel(CorsodiLaurea.class)
public class CorsodiLaurea_ { 

    public static volatile SingularAttribute<CorsodiLaurea, String> descrizione;
    public static volatile CollectionAttribute<CorsodiLaurea, Studente> studenteCollection;
    public static volatile CollectionAttribute<CorsodiLaurea, Materia> materiaCollection;
    public static volatile SingularAttribute<CorsodiLaurea, String> nome;
    public static volatile SingularAttribute<CorsodiLaurea, String> id;

}