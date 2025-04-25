package es.ies.puerto.model;
import java.util.Objects;
/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class Comodin {
    int id;
    int cantidad;
    String nombre;

    public Comodin() {
    }

    public Comodin(int id, int cantidad, String nombre) {
        this.id = id;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Comodin id(int id) {
        setId(id);
        return this;
    }

    public Comodin cantidad(int cantidad) {
        setCantidad(cantidad);
        return this;
    }

    public Comodin nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Comodin)) {
            return false;
        }
        Comodin comodin = (Comodin) o;
        return id == comodin.id && cantidad == comodin.cantidad && Objects.equals(nombre, comodin.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad, nombre);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }
    
}
