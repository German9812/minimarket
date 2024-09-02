package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-08-27T10:53:02")
@StaticMetamodel(Reporte.class)
public class Reporte_ { 

    public static volatile ListAttribute<Reporte, String> datos;
    public static volatile SingularAttribute<Reporte, Date> fechaInicio;
    public static volatile SingularAttribute<Reporte, String> tipoReporte;
    public static volatile SingularAttribute<Reporte, Date> fechaGeneracion;
    public static volatile SingularAttribute<Reporte, String> generadoPor;
    public static volatile SingularAttribute<Reporte, Integer> id;
    public static volatile SingularAttribute<Reporte, Date> fechaFin;

}