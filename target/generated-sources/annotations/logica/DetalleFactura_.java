package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Descuento;
import logica.Factura;
import logica.Producto;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-08-27T10:53:02")
@StaticMetamodel(DetalleFactura.class)
public class DetalleFactura_ { 

    public static volatile SingularAttribute<DetalleFactura, Double> total;
    public static volatile SingularAttribute<DetalleFactura, Double> precioUnitario;
    public static volatile SingularAttribute<DetalleFactura, Factura> factura;
    public static volatile SingularAttribute<DetalleFactura, Double> subtotal;
    public static volatile SingularAttribute<DetalleFactura, Descuento> descuentoAplicado;
    public static volatile SingularAttribute<DetalleFactura, Integer> id;
    public static volatile SingularAttribute<DetalleFactura, Producto> producto;
    public static volatile SingularAttribute<DetalleFactura, Integer> cantidad;

}