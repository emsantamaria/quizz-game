package es.ies.puerto.model;
import java.util.Objects;
/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class Respuesta{
    private String respuesta;
    private boolean correcta;

    public Respuesta() {
    }

    public Respuesta(String respuesta, boolean correcta) {
        this.respuesta = respuesta;
        this.correcta = correcta;
    }

    public String getRespuesta() {
        return this.respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isCorrecta() {
        return this.correcta;
    }

    public boolean getCorrecta() {
        return this.correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    public Respuesta respuesta(String respuesta) {
        setRespuesta(respuesta);
        return this;
    }

    public Respuesta correcta(boolean correcta) {
        setCorrecta(correcta);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Respuesta)) {
            return false;
        }
        Respuesta respuesta = (Respuesta) o;
        return Objects.equals(respuesta, respuesta.respuesta) && correcta == respuesta.correcta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(respuesta, correcta);
    }

    @Override
    public String toString() {
        return "{" +
            " respuesta='" + getRespuesta() + "'" +
            ", correcta='" + isCorrecta() + "'" +
            "}";
    }
    
}