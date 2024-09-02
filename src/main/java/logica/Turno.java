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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author germa
 */
@Entity
public class Turno implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_turno;
    
    private String hora_turno;
    private String afeccion; 
    
    @ManyToOne
    @JoinColumn(name = "administrador_id")
    private Administrador adminis;
    
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado emple;

    public Turno() {
    }

    public Turno(int id, Date fecha_turno, String hora_turno, String afeccion, Administrador adminis, Empleado emple) {
        this.id = id;
        this.fecha_turno = fecha_turno;
        this.hora_turno = hora_turno;
        this.afeccion = afeccion;
        this.adminis = adminis;
        this.emple = emple;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_turno() {
        return fecha_turno;
    }

    public void setFecha_turno(Date fecha_turno) {
        this.fecha_turno = fecha_turno;
    }

    public String getHora_turno() {
        return hora_turno;
    }

    public void setHora_turno(String hora_turno) {
        this.hora_turno = hora_turno;
    }

    public String getAfeccion() {
        return afeccion;
    }

    public void setAfeccion(String afeccion) {
        this.afeccion = afeccion;
    }

    public Administrador getAdminis() {
        return adminis;
    }

    public void setAdminis(Administrador adminis) {
        this.adminis = adminis;
    }

    public Empleado getEmple() {
        return emple;
    }

    public void setEmple(Empleado emple) {
        this.emple = emple;
    }

 
}
