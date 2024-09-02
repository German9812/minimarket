package logica;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Cliente;
import logica.Descuento;
import logica.DetalleFactura;
import logica.Empleado;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-08-27T10:53:02")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Cliente> cliente;
    public static volatile SingularAttribute<Factura, Date> fecha;
    public static volatile SingularAttribute<Factura, Double> total;
    public static volatile SingularAttribute<Factura, String> estado;
    public static volatile SingularAttribute<Factura, Empleado> empleado;
    public static volatile SingularAttribute<Factura, Double> subtotal;
    public static volatile SingularAttribute<Factura, Double> impuestos;
    public static volatile SingularAttribute<Factura, Descuento> descuentoGeneral;
    public static volatile ListAttribute<Factura, DetalleFactura> detalles;
    public static volatile SingularAttribute<Factura, Integer> id;
    public static volatile SingularAttribute<Factura, String> formaPago;

}