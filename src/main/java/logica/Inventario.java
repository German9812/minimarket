/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author germa
 */
@Entity
public class Inventario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @OneToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    
    private int cantidadDisponible;
    private int cantidadMinima;
    private String ubicacion;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaUltimoReabastecimiento;

    public Inventario() {
    }

    public Inventario(int id, Producto producto, int cantidadDisponible, int cantidadMinima, String ubicacion, Date fechaUltimoReabastecimiento) {
        this.id = id;
        this.producto = producto;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidadMinima = cantidadMinima;
        this.ubicacion = ubicacion;
        this.fechaUltimoReabastecimiento = fechaUltimoReabastecimiento;
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

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaUltimoReabastecimiento() {
        return fechaUltimoReabastecimiento;
    }

    public void setFechaUltimoReabastecimiento(Date fechaUltimoReabastecimiento) {
        this.fechaUltimoReabastecimiento = fechaUltimoReabastecimiento;
    }
    
    

}
