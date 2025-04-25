package es.ies.puerto.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.Usuario;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class LoginController {
    @FXML Button respuestaD;
    Usuario usuario;
    AudioClip clip;

    /**
     * Constructor de la clase `LoginController`.
     */
    public LoginController() {

    }

    /**
     * Método para inicializar el controlador con un usuario.
     * @param usuario Usuario que inicia sesión.
     */
    public void initializate(Usuario usuario) {
        this.usuario = usuario;
        play("menu-53679.mp3", 1.0, 0);
    }

    /**
     * Método para iniciar el juego desde el menú.
     * @param event Evento de acción del botón.
     */
    @FXML
    protected void jugar(ActionEvent event) {
        clip.stop();
        Button button = (Button) event.getSource();
        FXMLLoader loader = new FXMLLoader(PrincipalApplication.class.getResource("initRead.fxml"));
        Parent root;
        try {
            root = loader.load();

            InicioController registroController = loader.getController();
            registroController.initializate(usuario, button.getText());
            registroController.ponerTextos();

            Stage stage = (Stage) respuestaD.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para abrir la tienda.
     */
    @FXML
    protected void tienda() {
        clip.stop();
        FXMLLoader loader = new FXMLLoader(PrincipalApplication.class.getResource("tienda.fxml"));
        Parent root;
        try {
            root = loader.load();

            TiendaController registroController = loader.getController();

            registroController.initializate(this.usuario);
            Stage stage = (Stage) respuestaD.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para abrir la pantalla de usuario.
     */
    @FXML
    protected void usuario() {
        clip.stop();
        FXMLLoader loader = new FXMLLoader(PrincipalApplication.class.getResource("usuario.fxml"));
        Parent root;
        try {
            root = loader.load();

            UsuarioController registroController = loader.getController();
            registroController.preInitializate();
            registroController.initializate(usuario);

            Stage stage = (Stage) respuestaD.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método para reproducir un archivo de sonido.
     * @param soundFile Nombre del archivo de sonido.
     * @param volume Volumen del sonido (0.0 a 1.0).
     * @param delaySeconds Tiempo de retraso antes de reproducir el sonido.
     */
    public void play(String soundFile, double volume, double delaySeconds) {
        try {
            //AudioClip clip = new AudioClip(SoundPlayer.class.getResource("/sounds/" + soundFile).toExternalForm());

            File file = new File("" + soundFile);
            URL url = getClass().getResource("/sounds/" + file);
            if (!file.exists()) {
            }

            this.clip = new AudioClip(url.toString());

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
