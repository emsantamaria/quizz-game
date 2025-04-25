package es.ies.puerto.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class Preguntas {
    List<Pregunta>preguntas;
    Bbdd bbdd;
    String url="jdbc:sqlite:src/main/resources/db/preguntas.db";
    public Preguntas() {
       
        bbdd=new Bbdd(url);
        preguntas=bbdd.loadPreguntas();
        try {
            bbdd.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Preguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public List<Pregunta> getPreguntas() {
        return this.preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public Preguntas preguntas(List<Pregunta> preguntas) {
        setPreguntas(preguntas);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Preguntas)) {
            return false;
        }
        Preguntas preguntas = (Preguntas) o;
        return Objects.equals(preguntas, preguntas.preguntas);
    }


    @Override
    public String toString() {
        return "{" +
            " preguntas='" + getPreguntas() + "'" +
            "}";
    }
    
    public List<Pregunta> findByTipo(String tipo){
        if(tipo.equals("Completo")){
            return preguntas;
        }
        List<Pregunta>preguntasTipo=new ArrayList<>();
        for (Pregunta pregunta : preguntas) {
            if(pregunta.getTipo().equals(tipo)){
                preguntasTipo.add(pregunta);
            }
        }
        return preguntasTipo;
    }
    
}
