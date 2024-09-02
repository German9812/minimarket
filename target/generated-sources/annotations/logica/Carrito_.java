package logica;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Carrito.EstadoCarrito;
import logica.Cliente;
import logica.Producto;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-08-27T10:53:02")
@StaticMetamodel(Carrito.class)
public class Carrito_ { 

    public static volatile SingularAttribute<Carrito, Cliente> cliente;
    public static volatile SingularAttribute<Carrito, Double> total;
    public static volatile SingularAttribute<Carrito, EstadoCarrito> estado;
    public static volatile SingularAttribute<Carrito, Integer> id;
    public static volatile SingularAttribute<Carrito, LocalDateTime> fecha_creacion;
    public static volatile MapAttribute<Carrito, Producto, Integer> productos;

}