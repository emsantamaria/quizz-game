package es.ies.puerto.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.Comodin;
import es.ies.puerto.model.Pregunta;
import es.ies.puerto.model.Preguntas;
import es.ies.puerto.model.Respuesta;
import es.ies.puerto.model.Usuario;
import es.ies.puerto.model.Usuarios;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class InicioController {

    private int tiempoSegundos;
    private Timeline timeline;
    AudioClip clip ;
    @FXML
    Text textMensaje;
    @FXML
    Text tiempo;
    Preguntas preguntas;
    Pregunta pregunta;
    int pocision = 0;
    String tipoUnico;
    List<Pregunta> preguntasTipo;
    @FXML
    TextArea preguntaText;
    @FXML
    Button respuestaA;
    @FXML
    Button respuestaB;
    @FXML
    Button respuestaC;
    @FXML
    Button respuestaD;
    List<Button> listButton;
    List<Circle> listCircle;
    @FXML
    Circle circle1;
    @FXML
    Circle circle2;
    @FXML
    Circle circle3;
    @FXML
    Circle circle4;
    @FXML
    Circle circle5;
    @FXML
    Circle circle6;
    List<Pregunta> preguntas6;
    int puntuacionFinal;
    Usuario usuario;
    Usuarios usuarios;
    @FXML Text correcto;

    public InicioController() {

    }
    /**
     * Metodo inicializador
     * @param usuario
     * @param tipo
     */
    public void initializate(Usuario usuario, String tipo) {
        puntuacionFinal=0;
        preguntas = new Preguntas();
        usuarios = new Usuarios();
        this.usuario = usuario;
        tipoUnico = tipo;
        preguntasTipo = preguntas.findByTipo(tipoUnico);
        preguntas6 = new ArrayList<>();
        preguntas();
    }
    /**
     * Metodo que refresca las preguntas,cronometro y otros valores
     */
    public void ponerTextos() {
        play("tic-tac-27828.mp3", 1.0, 0);
        pregunta = preguntas6.get(pocision);
        tiempoSegundos = 10;
        listButton = new ArrayList<>(Arrays.asList(respuestaA, respuestaB, respuestaC, respuestaD));
        listCircle = new ArrayList<>(Arrays.asList(circle1, circle2, circle3, circle4, circle5, circle6));
        preguntaText.setText(pregunta.getPregunta());
        for (int i = 0; i < listButton.size(); i++) {
            listButton.get(i).setVisible(false);
            if (i < pregunta.getRespuestas().size()) {
                listButton.get(i).setVisible(true);
                listButton.get(i).setText(pregunta.getRespuestas().get(i).getRespuesta());
            }
        }
        activar();
        cronometro();
        correcto.setText("");
    }

    /**
     * Metodo que filtra y subtrae 6 preguntas para la ronda
     * @return
     */
    public List<Pregunta> preguntas() {
        if (preguntasTipo.size() < 7) {
            preguntas6 = preguntasTipo;
            return preguntas6;
        }
        for (int i = 0; i < 7; i++) {
            Pregunta pregunta = preguntasTipo.get((int) (Math.random() * preguntasTipo.size()));
            if (!preguntas6.contains(pregunta)) {
                preguntas6.add(pregunta);
            } else {
                i--;
            }
        }
        return preguntas6;
    }

    /**
     * Metodo que dicta si respondiste bien o mal, y hace los cambios necesarios para que se entienda
     * @param actionEvent
     */
    @FXML
    protected void comprobar(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        Respuesta preguntaEncontrada = pregunta.find(button.getText());
        desactivar();
        this.clip.stop();
        if (preguntaEncontrada.getCorrecta()) {
            puntuacionFinal += 1 + Integer.parseInt(tiempo.getText());
            timeline.stop();
            cambiarColor(button.getText(), "green");
            cambiarCirculo(Color.DARKGREEN);
            modificarPocision();
            play("spin-complete-295086.mp3", 1.0, 0);
            correcto.setText("CORRECTO");
            correcto.setFill(Color.DARKGREEN);
            PauseTransition pausa = new PauseTransition(Duration.millis(600));
            pausa.setOnFinished(event -> {
                pregunta = preguntas6.get(pocision);
                ponerTextos();
                reestaurarColores();
                terminar();
            });
            pausa.play();
            textMensaje.setText("");
          
        } else {
            desactivar();
            timeline.stop();
            cambiarColor(button.getText(), "red");
            cambiarCirculo(Color.DARKRED);
            mostrarCorrecto();
            play("fail-234710.mp3", 1.0, 0);
            correcto.setText("EQUIVOCADO");
            correcto.setFill(Color.DARKRED);
            modificarPocision();
            PauseTransition pausa = new PauseTransition(Duration.millis(600));
            pausa.setOnFinished(event -> {
                pregunta = preguntas6.get(pocision);
                ponerTextos();
                reestaurarColores();
                terminar();
            });
            pausa.play();
            textMensaje.setText("");
            
        }
    }

    /**
     * Metodo que cambia el color del boton pulsado
     * @param text
     * @param color
     */
    public void cambiarColor(String text, String color) {
        for (Button buttonBuscar : listButton) {
            if (buttonBuscar.getText().equals(text)) {
                buttonBuscar.setStyle("-fx-background-color:" + color);
            }
        }
    }

    /**
     * Metodo que muestra cual era la respuesta correcta
     */
    public void mostrarCorrecto() {
        for (Respuesta button : pregunta.getRespuestas()) {
            if (button.getCorrecta()) {
                cambiarColor(button.getRespuesta(), "green");
            }
        }
    }

    /**
     * Metodo que permite pasar palabra
     */
    @FXML
    protected void pasarPalabra() {
        if (!listCircle.get(pocision).getFill().equals(Color.WHITE)) {
            return;
        }
        timeline.stop();
        cambiarCirculo(Color.GRAY);
        modificarPocision();
        pregunta = preguntas6.get(pocision);
        ponerTextos();
        reestaurarColores();
        textMensaje.setText("");

    }

    /**
     * MEtodo que permite cambiar de color a los circulos
     * @param color
     */
    public void cambiarCirculo(Color color) {
        listCircle.get(pocision).setFill(color);
    }

    /**
     * Metodo que actualiza pocision
     */
    public void modificarPocision() {
        if (pocision == preguntas6.size() - 1) {
            pocision = 0;
        }
        for (int i = 0; i < listCircle.size(); i++) {
            if (listCircle.get(i).getFill().equals(Color.WHITE)) {
                pocision = i;
                return;
            }
        }
        for (int i = 0; i < listCircle.size(); i++) {
            if (listCircle.get(i).getFill().equals(Color.GRAY)) {
                pocision = i;
                return;
            }

        }
    }

    /**
     * Metodo que restaura los colores de los botones
     */
    public void reestaurarColores() {
        for (Button button : listButton) {
            button.setStyle("-fx-background-color:white");
        }
    }

    /**
     * Metodo responsable del cronometro
     */
    public void cronometro() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            tiempo.setFill(Color.GREEN);
            tiempoSegundos--;
            tiempo.setText(tiempoSegundos + "");
            if (tiempoSegundos < 6) {
                tiempo.setFill(Color.ORANGE);
            }
            if (tiempoSegundos < 4) {
                tiempo.setFill(Color.RED);
            }
            if (tiempoSegundos <= 0) {
                timeline.stop();
                desactivar();
                cambiarCirculo(Color.RED);
                mostrarCorrecto();
                modificarPocision();
                play("wind-up-clock-alarm-bell-64219.mp3", 1.0, 0);
                PauseTransition pausa = new PauseTransition(Duration.millis(600));
                pausa.setOnFinished(event -> {
                    clip.stop();
                    pregunta = preguntas6.get(pocision);
                    ponerTextos();
                    reestaurarColores();
                    terminar();
                });
                pausa.play();
                textMensaje.setText("");
            }
        }));
        timeline.setCycleCount(tiempoSegundos);
        timeline.play();
    }

    /**
     * Metodo que desactiva todos los botones
     */
    public void desactivar() {
        for (Button button : listButton) {
            button.setDisable(true);
        }
    }

    /**
     * MEtodo que activa todos los botones
     */
    public void activar() {
        for (Button button : listButton) {
            button.setDisable(false);
        }
    }

    /**
     * Metodo que comprueba si la ronda ha terminado
     */
    public void terminar() {
        for (Circle circle : listCircle) {
            if (circle.getFill().equals(Color.WHITE) || circle.getFill().equals(Color.GRAY)) {
                return;
            }
        }
        clip.stop();
        timeline.stop();
        int puntuacion = 0;
        for (Circle circle : listCircle) {
            if (circle.getFill().equals(Color.DARKGREEN)) {
                puntuacion++;
            }
        }
        jugar(puntuacion);
    }

    /**
     * Metodo que abre la pantalla final
     * @param puntuacion
     */
    protected void jugar(int puntuacion) {
        usuario.actualizarPuntuacion(puntuacionFinal);
        usuarios.upadte(usuario);
        FXMLLoader loader = new FXMLLoader(PrincipalApplication.class.getResource("final.fxml"));
        try {

            Parent root = loader.load();
            FinalController registroController = loader.getController();
            registroController.initializate(puntuacion, usuario);

            Stage stage = (Stage) textMensaje.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que necesario para utilizar comodines
     */
    public void comodin(ActionEvent event) {
        Button button = (Button) event.getSource();
        for (Comodin comodin : usuario.getComodines()) {
            if (comodin.getNombre().equals(button.getId())) {
                if (comodin.getCantidad() < 1) {
                    textMensaje.setText("Cantidad de Comodin insuficiente");
                    return;
                }
                comodin.setCantidad(comodin.getCantidad() - 1);
                switch (button.getId()) {
                    case "pista":
                        pista();
                        break;
                    case "completar":
                        completar();
                        break;
                    case "mediaEliminacion":
                        mitad();
                        break;
                    default:
                    eliminar1();
                        break;
                }

            }
        }
    }

    /**
     * Metodo del comodin eliminar1
     */
    public void eliminar1() {
        int cantidad=1;
        while (cantidad>0) {
            int pocisionRandom = (int) (Math.random() * pregunta.getRespuestas().size());
            if (!pregunta.getRespuestas().get(pocisionRandom).getCorrecta()) {
                if (eliminarRespuestas(pregunta.getRespuestas().get(pocisionRandom).getRespuesta())) {
                    cantidad--;
                }
            }
        }
    }

    /**
     * Metodo que elimina respuestas incorrectas
     * @param nombre
     * @return
     */
    public boolean eliminarRespuestas(String nombre) {
        for (Button button : listButton) {
            if (button.getText().equals(nombre)) {
                if (button.isVisible()) {
                    button.setDisable(true);
                    button.setVisible(false);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * MEtodo del comodin de completar
     */
    public void completar() {
        timeline.stop();
        mostrarCorrecto();
        cambiarCirculo(Color.GREEN);
        modificarPocision();
        play("spin-complete-295086.mp3", 1.0, 0);
        PauseTransition pausa = new PauseTransition(Duration.millis(600));
        pausa.setOnFinished(event -> {
            pregunta = preguntas6.get(pocision);
            ponerTextos();
            reestaurarColores();
            terminar();
        });
        pausa.play();
        textMensaje.setText("");
    }

    /**
     * MEtodo del comodin de pista
     */
    public void pista() {
        textMensaje.setText(pregunta.getPista());
    }

    /**
     * metodo del comodin de mitad respuestas
     */
    public void mitad() {
        int cantidad = 2;
        if (pregunta.getRespuestas().size() % 2 == 0) {
            cantidad = pregunta.getRespuestas().size() / 2;
        } else {
            cantidad = (pregunta.getRespuestas().size() - 1) / 2;
        }
        while (cantidad > 0) {
            int pocisionRandom = (int) (Math.random() * pregunta.getRespuestas().size());
            if (!pregunta.getRespuestas().get(pocisionRandom).getCorrecta()) {
                if (eliminarRespuestas(pregunta.getRespuestas().get(pocisionRandom).getRespuesta())) {
                    cantidad--;
                }
            }
        }
    }

    /**
     * Metodo que permite poner una `pista de audio
     * @param soundFile
     * @param volume
     * @param delaySeconds
     */
    public void play(String soundFile, double volume, double delaySeconds) {
        try {
            //AudioClip clip = new AudioClip(SoundPlayer.class.getResource("/sounds/" + soundFile).toExternalForm());

            File file = new File("" + soundFile);
            URL url=getClass().getResource("/sounds/"+file);
            if (!file.exists()) {
                
            }

            clip = new AudioClip(url.toString());

            clip.setVolume(Math.max(0.0, Math.min(volume, 1.0)));

            if (delaySeconds > 0) {
                PauseTransition delay = new PauseTransition(Duration.seconds(delaySeconds));
                delay.setOnFinished(e -> clip.play());
                delay.play();
            } else {
                clip.play();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
