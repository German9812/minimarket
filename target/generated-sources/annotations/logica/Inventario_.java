package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Producto;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-08-27T10:53:02")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, Date> fechaUltimoReabastecimiento;
    public static volatile SingularAttribute<Inventario, Integer> cantidadMinima;
    public static volatile SingularAttribute<Inventario, String> ubicacion;
    public static volatile SingularAttribute<Inventario, Integer> id;
    public static volatile SingularAttribute<Inventario, Producto> producto;
    public static volatile SingularAttribute<Inventario, Integer> cantidadDisponible;

}