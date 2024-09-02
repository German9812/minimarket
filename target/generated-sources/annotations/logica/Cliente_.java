package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Factura;
import logica.Venta;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-08-27T10:53:02")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Persona_ {

    public static volatile ListAttribute<Cliente, Factura> facturas;
    public static volatile ListAttribute<Cliente, Venta> ventas;

}