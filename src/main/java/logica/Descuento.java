/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

/**
 *
 * @author germa
 */
@Entity
public class Descuento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nombre;
    private String descripcion;
    private double porcentajeDescuento;
    private double montoFijo;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;
    
    @ManyToMany
    @JoinTable(name = "descuento_producto",
               joinColumns = @JoinColumn(name = "descuento_id"),
               inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> productos;
    
    @Enumerated(EnumType.STRING)
    private EstadoDescuento estado;

    public enum EstadoDescuento {
        ACTIVO,
        INACTIVO
    }

    public Descuento() {
    }

    public Descuento(int id, String nombre, String descripcion, double porcentajeDescuento, double montoFijo, Date fechaInicio, Date fechaFin, List<Producto> productos, EstadoDescuento estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.porcentajeDescuento = porcentajeDescuento;
        this.montoFijo = montoFijo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.productos = productos;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getMontoFijo() {
        return montoFijo;
    }

    public void setMontoFijo(double montoFijo) {
        this.montoFijo = montoFijo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public EstadoDescuento getEstado() {
        return estado;
    }

    public void setEstado(EstadoDescuento estado) {
        this.estado = estado;
    }
    
    

    
}
