/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author germa
 */
@Entity
public class DetalleFactura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    
    private int cantidad;
    private double precioUnitario;
    private double subtotal;
    
    @ManyToOne
    @JoinColumn(name = "descuento_id")
    private Descuento descuentoAplicado;
    
    private double total;

    @ManyToOne
    @JoinColumn(name = "factura_id")  // Este campo establece la relación con Factura
    private Factura factura;
    
    public DetalleFactura() {
    }

    public DetalleFactura(int id, Producto producto, int cantidad, double precioUnitario, double subtotal, Descuento descuentoAplicado, double total, Factura factura) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.descuentoAplicado = descuentoAplicado;
        this.total = total;
        this.factura = factura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Descuento getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public void setDescuentoAplicado(Descuento descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    
}