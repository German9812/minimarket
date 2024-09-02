/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;

/**
 *
 * @author germa
 */
@Entity
public class Reporte implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String tipoReporte;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;
    
    @ElementCollection
    @CollectionTable(name = "reporte_datos", joinColumns = @JoinColumn(name = "reporte_id"))
    @Column(name = "dato")
    private List<String> datos;
    
    private String generadoPor;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaGeneracion;

    public Reporte() {
    }

    public Reporte(int id, String tipoReporte, Date fechaInicio, Date fechaFin, List<String> datos, String generadoPor, Date fechaGeneracion) {
        this.id = id;
        this.tipoReporte = tipoReporte;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.datos = datos;
        this.generadoPor = generadoPor;
        this.fechaGeneracion = fechaGeneracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(String tipoReporte) {
        this.tipoReporte = tipoReporte;
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

    public List<String> getDatos() {
        return datos;
    }

    public void setDatos(List<String> datos) {
        this.datos = datos;
    }

    public String getGeneradoPor() {
        return generadoPor;
    }

    public void setGeneradoPor(String generadoPor) {
        this.generadoPor = generadoPor;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    
    
}
