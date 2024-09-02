package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.CategoriaProducto.EstadoCategoria;
import logica.Producto;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-08-27T10:53:02")
@StaticMetamodel(CategoriaProducto.class)
public class CategoriaProducto_ { 

    public static volatile SingularAttribute<CategoriaProducto, String> descripcion;
    public static volatile SingularAttribute<CategoriaProducto, EstadoCategoria> estado;
    public static volatile SingularAttribute<CategoriaProducto, Integer> id;
    public static volatile SingularAttribute<CategoriaProducto, String> nombre;
    public static volatile ListAttribute<CategoriaProducto, Producto> productos;

}