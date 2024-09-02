package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author germa
 */
@Entity
public class CategoriaProducto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nombre;
    private String descripcion;
    
    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;
    
    @Enumerated(EnumType.STRING)
    private EstadoCategoria estado;

    public enum EstadoCategoria {
        ACTIVA,
        INACTIVA
    }

    public CategoriaProducto() {
    }

    public CategoriaProducto(int id, String nombre, String descripcion, List<Producto> productos, EstadoCategoria estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public EstadoCategoria getEstado() {
        return estado;
    }

    public void setEstado(EstadoCategoria estado) {
        this.estado = estado;
    }
}
