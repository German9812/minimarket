/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author germa
 */
@Entity
public class Empleado extends Persona implements Serializable {
    
   // private String id_empleado;
    
    @OneToMany (mappedBy="emple")
    private List<Turno> listaTurnos;
    
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario unUsuario;
    @OneToOne
    @JoinColumn(name = "horario_id")
    private Horario unHorario;

    public Empleado() {
    }

    public Empleado(List<Turno> listaTurnos, Usuario unUsuario, Horario unHorario) {
        this.listaTurnos = listaTurnos;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
    }

    public Empleado(List<Turno> listaTurnos, Usuario unUsuario, Horario unHorario, int id, String cedula, String nombre, String apellido, String telefono) {
        super(id, cedula, nombre, apellido, telefono);
        this.listaTurnos = listaTurnos;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Horario getUnHorario() {
        return unHorario;
    }

    public void setUnHorario(Horario unHorario) {
        this.unHorario = unHorario;
    }
    

    
    
}
