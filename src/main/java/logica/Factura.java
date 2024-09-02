package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author germa
 */
@Entity
public class Factura implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    @OneToMany(mappedBy = "factura")
    private List<DetalleFactura> detalles;
    
    private double subtotal;
    private double impuestos;
    private double total;
    
    @ManyToOne
    @JoinColumn(name = "descuento_general_id")
    private Descuento descuentoGeneral;
    
    private String formaPago;
    private String estado;

    public Factura() {
    }

    public Factura(int id, Cliente cliente, Empleado empleado, Date fecha, List<DetalleFactura> detalles, double subtotal, double impuestos, double total, Descuento descuentoGeneral, String formaPago, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fecha = fecha;
        this.detalles = detalles;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.total = total;
        this.descuentoGeneral = descuentoGeneral;
        this.formaPago = formaPago;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
        for (DetalleFactura detalle : detalles){
            detalle.setFactura(this); // para establecer relacion bidireccional 
        }
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Descuento getDescuentoGeneral() {
        return descuentoGeneral;
    }

    public void setDescuentoGeneral(Descuento descuentoGeneral) {
        this.descuentoGeneral = descuentoGeneral;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
