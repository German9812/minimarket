/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
/**
 *
 * @author germa
 */
@Entity
public class Cliente extends Persona implements Serializable{
    
    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;
    
    @OneToMany(mappedBy = "cliente")
    private List<Venta> ventas;

    public Cliente() {
    }

    public Cliente(List<Factura> facturas, List<Venta> ventas) {
        this.facturas = facturas;
        this.ventas = ventas;
    }

    public Cliente(List<Factura> facturas, List<Venta> ventas, int id, String cedula, String nombre, String apellido, String telefono) {
        super(id, cedula, nombre, apellido, telefono);
        this.facturas = facturas;
        this.ventas = ventas;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    
}
