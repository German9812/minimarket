package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Descuento.EstadoDescuento;
import logica.Producto;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-08-27T10:53:02")
@StaticMetamodel(Descuento.class)
public class Descuento_ { 

    public static volatile SingularAttribute<Descuento, String> descripcion;
    public static volatile SingularAttribute<Descuento, EstadoDescuento> estado;
    public static volatile SingularAttribute<Descuento, Double> porcentajeDescuento;
    public static volatile SingularAttribute<Descuento, Date> fechaInicio;
    public static volatile SingularAttribute<Descuento, Integer> id;
    public static volatile SingularAttribute<Descuento, String> nombre;
    public static volatile SingularAttribute<Descuento, Double> montoFijo;
    public static volatile SingularAttribute<Descuento, Date> fechaFin;
    public static volatile ListAttribute<Descuento, Producto> productos;

}