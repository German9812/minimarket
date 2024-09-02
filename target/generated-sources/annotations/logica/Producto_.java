package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.CategoriaProducto;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-08-27T10:53:02")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Double> precio;
    public static volatile SingularAttribute<Producto, CategoriaProducto> categoria;
    public static volatile SingularAttribute<Producto, Integer> id;
    public static volatile SingularAttribute<Producto, Double> cantidad;
    public static volatile SingularAttribute<Producto, String> nombre;

}