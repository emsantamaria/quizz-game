package es.ies.puerto.model;

import java.util.List;
import java.util.Objects;
/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class Usuario {
    private String nombre;
    List<Comodin>comodines;
    int id;
    int puntaje;
    /**
     * Contructor vacio
     */
    public Usuario() {
    }

    /**
     * Constructor con nombre y puntaje.
     * @param nombre Nombre del usuario.
     * @param puntaje Puntaje inicial del usuario.
     */
    public Usuario(String nombre,int puntaje) {
        this.nombre=nombre;
        this.puntaje=puntaje;
    }

    /**
     * Constructor con todos los atributos.
     * @param nombre Nombre del usuario.
     * @param comodines Lista de comodines del usuario.
     * @param id Identificador único del usuario.
     * @param puntaje Puntaje inicial del usuario.
     */
    public Usuario(String nombre, List<Comodin> comodines, int id, int puntaje) {
        this.nombre = nombre;
        this.comodines = comodines;
        this.id = id;
        this.puntaje = puntaje;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return Nombre del usuario.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del usuario.
     * @param nombre Nombre del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de comodines del usuario.
     * @return Lista de comodines.
     */
    public List<Comodin> getComodines() {
        return this.comodines;
    }

    /**
     * Establece la lista de comodines del usuario.
     * @param comodines Lista de comodines.
     */
    public void setComodines(List<Comodin> comodines) {
        this.comodines = comodines;
    }

    /**
     * Obtiene el identificador único del usuario.
     * @return Identificador único.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Establece el identificador único del usuario.
     * @param id Identificador único.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el puntaje del usuario.
     * @return Puntaje del usuario.
     */
    public int getPuntaje() {
        return this.puntaje;
    }

    /**
     * Establece el puntaje del usuario.
     * @param puntaje Puntaje del usuario.
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Método fluido para establecer el nombre del usuario.
     * @param nombre Nombre del usuario.
     * @return Instancia actualizada del usuario.
     */
    public Usuario nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    /**
     * Método fluido para establecer la lista de comodines del usuario.
     * @param comodines Lista de comodines.
     * @return Instancia actualizada del usuario.
     */
    public Usuario comodines(List<Comodin> comodines) {
        setComodines(comodines);
        return this;
    }

    /**
     * Método fluido para establecer el identificador único del usuario.
     * @param id Identificador único.
     * @return Instancia actualizada del usuario.
     */
    public Usuario id(int id) {
        setId(id);
        return this;
    }

    /**
     * Método fluido para establecer el puntaje del usuario.
     * @param puntaje Puntaje del usuario.
     * @return Instancia actualizada del usuario.
     */
    public Usuario puntaje(int puntaje) {
        setPuntaje(puntaje);
        return this;
    }

    /**
     * Compara si dos objetos Usuario son iguales.
     * @param o Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(comodines, usuario.comodines) && id == usuario.id && puntaje == usuario.puntaje;
    }

    /**
     * Genera un código hash para el usuario.
     * @return Código hash del usuario.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre, comodines, id, puntaje);
    }

    /**
     * Genera una representación en cadena del usuario.
     * @return Representación en cadena del usuario.
     */
    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", comodines='" + getComodines() + "'" +
            ", id='" + getId() + "'" +
            ", puntaje='" + getPuntaje() + "'" +
            "}";
    }

    /**
     * Actualiza el puntaje del usuario sumando una cantidad.
     * @param cantidad Cantidad a sumar al puntaje actual.
     */
    public void actualizarPuntuacion(int cantidad){
        this.puntaje=puntaje+cantidad;
    }

}
