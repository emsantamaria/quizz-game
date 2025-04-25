package es.ies.puerto.model;

import java.util.List;
import java.util.Objects;
/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class Pregunta {
    List<Respuesta>respuestas;
    String pregunta;
    int id;
    String tipo;
    String pista;

    public Pregunta(List<Respuesta> respuestas, String pregunta, int id, String tipo, String pista) {
        this.respuestas = respuestas;
        this.pregunta = pregunta;
        this.id = id;
        this.tipo = tipo;
        this.pista = pista;
    }

    public String getPista() {
        return this.pista;
    }

    public void setPista(String pista) {
        this.pista = pista;
    }

    public Pregunta pista(String pista) {
        setPista(pista);
        return this;
    }
    
    public Pregunta() {
    }

    public Pregunta(List<Respuesta> respuestas, String pregunta, int id, String tipo) {
        this.respuestas = respuestas;
        this.pregunta = pregunta;
        this.id = id;
        this.tipo = tipo;
    }

    public List<Respuesta> getRespuestas() {
        return this.respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public String getPregunta() {
        return this.pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pregunta respuestas(List<Respuesta> respuestas) {
        setRespuestas(respuestas);
        return this;
    }

    public Pregunta pregunta(String pregunta) {
        setPregunta(pregunta);
        return this;
    }

    public Pregunta id(int id) {
        setId(id);
        return this;
    }

    public Pregunta tipo(String tipo) {
        setTipo(tipo);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pregunta)) {
            return false;
        }
        Pregunta pregunta = (Pregunta) o;
        return Objects.equals(respuestas, pregunta.respuestas) && Objects.equals(pregunta, pregunta.pregunta) && id == pregunta.id && Objects.equals(tipo, pregunta.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(respuestas, pregunta, id, tipo);
    }

    @Override
    public String toString() {
        return "{" +
            " respuestas='" + getRespuestas() + "'" +
            ", pregunta='" + getPregunta() + "'" +
            ", id='" + getId() + "'" +
            ", tipo='" + getTipo() + "'" +
            ", pista='" + getPista() + "'" +
            "}";
    }

    public Respuesta find(String nombre){
        Respuesta respuesta=new Respuesta();
        for (int i = 0; i < respuestas.size(); i++) {
            if(respuestas.get(i).getRespuesta().equals(nombre)){
                respuesta=respuestas.get(i);
            }
        }
        return respuesta;
    }
  
}