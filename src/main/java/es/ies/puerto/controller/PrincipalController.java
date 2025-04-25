package es.ies.puerto.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.Usuario;
import es.ies.puerto.model.Usuarios;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class PrincipalController {
    Usuarios usuarios;
    AudioClip clip;
    @FXML TextField textField;

    /**
     * Constructor de la clase `PrincipalController`.
     */
    public PrincipalController(){
        usuarios=new Usuarios();
        play("cinematic-intro-6097.mp3", 1.0, 0);
    }

    /**
     * Método para iniciar sesión con un usuario existente.
     */
    @FXML
    protected void iniciar(){
        if(textField==null||textField.getText().isBlank()){
            return;
        }
        if(usuarios.findByName(textField.getText())!=null){
            jugar(usuarios.findByName(textField.getText()));
        }
    }

    /**
     * Método para registrar un nuevo usuario.
     */
    @FXML 
    protected void register(){
        clip.stop();
        FXMLLoader loader = new FXMLLoader(PrincipalApplication.class.getResource("register.fxml"));
        Parent root;
        try {
            root = loader.load();
        RegisterController registroController = loader.getController();

        Stage stage = (Stage) textField.getScene().getWindow();
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
            URL url = getClass().getResource("/sounds/" + soundFile);
            if (url == null) {
                return;
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

    /**
     * Método para iniciar el juego con un usuario.
     * @param usuario Usuario que inicia el juego.
     */
    protected void jugar(Usuario usuario){
        clip.stop();
        FXMLLoader loader = new FXMLLoader(PrincipalApplication.class.getResource("jugar.fxml"));
            Parent root;
            try {
                root = loader.load();
    
            LoginController registroController = loader.getController();
            
           registroController.initializate(usuario);
    
            Stage stage = (Stage) textField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
