package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Administrador;
import logica.Empleado;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-08-27T10:53:02")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, String> afeccion;
    public static volatile SingularAttribute<Turno, String> hora_turno;
    public static volatile SingularAttribute<Turno, Empleado> emple;
    public static volatile SingularAttribute<Turno, Integer> id;
    public static volatile SingularAttribute<Turno, Administrador> adminis;
    public static volatile SingularAttribute<Turno, Date> fecha_turno;

}