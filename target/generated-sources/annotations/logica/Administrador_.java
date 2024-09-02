package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Horario;
import logica.Turno;
import logica.Usuario;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2024-08-27T10:53:02")
@StaticMetamodel(Administrador.class)
public class Administrador_ extends Persona_ {

    public static volatile SingularAttribute<Administrador, Usuario> unUsuario;
    public static volatile ListAttribute<Administrador, Turno> listaTurnos;
    public static volatile SingularAttribute<Administrador, Horario> unHorario;

}