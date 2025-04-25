package es.ies.puerto.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.Usuario;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class FinalController {
    @FXML Button puntuacion;
    @FXML Text texto;
    @FXML Text mensaje;
    Usuario usuario;
    public FinalController(){
    }
    AudioClip clip;
    public void initializate(int puntuacion,Usuario usuario){
        this.usuario=usuario;
        mensaje2(puntuacion);
        texto.setText(mensaje(puntuacion));
        this.puntuacion.setText(puntuacion+"/6");
        
        
        
    }

    public String mensaje(int puntuacion){
        String escribir="";
        switch (puntuacion) {
            case 0:
                escribir="Hoy no era tu dia";
                mensaje.setText(escribir);
                break;
            case 1:
                escribir="Podria ser peor";
                mensaje.setText(escribir);
                break;
            case 2:
                escribir="Deberias practicar mas";
                mensaje.setText(escribir);
                break;
            case 3:
                escribir="¡Justo la mitad!";
                mensaje.setText(escribir);
                break;
            case 4:
                escribir="¡Nada Mal!";
                mensaje.setText(escribir);
                break;
            case 5:
                escribir="¡Increible!";
                mensaje.setText(escribir);
                break; 
            default:
            escribir="¡¡¡¡PERFERCTOO!!!!";
            mensaje.setText(escribir);
                break;
        }
        return escribir;
    }
    public String mensaje2(int puntuacion){
        String escribir="";
        switch (puntuacion) {
            case 0:
                escribir="Mejor suerte la proxima";
                play("wah-wah-sad-trombone-6347.mp3", 1.0, 0);
                break;
            case 1:
                escribir="¿Estas bien?";
                play("wah-wah-sad-trombone-6347.mp3", 1.0, 0);
                break;
            case 2:
                escribir="Sigue intentandolo";
                play("wah-wah-sad-trombone-6347.mp3", 1.0, 0);
                break;
            case 3:
                escribir="Simetria pura";
                play("crowd-cheer-in-school-auditorium-236699.mp3wah-wah-sad-trombone-6347.mp3", 1.0, 0);
                break;
            case 4:
                escribir="Fiu, muy bien";
                play("crowd-cheer-in-school-auditorium-236699.mp3wah-wah-sad-trombone-6347.mp3", 1.0, 0);
                break;
            case 5:
                escribir="Eres el maestro de las preguntas";
                play("crowd-cheer-in-school-auditorium-236699.mp3wah-wah-sad-trombone-6347.mp3", 1.0, 0);
                break; 
            default:
            escribir="¡¡¡DIOOOOOOS!!!!";
                play("wow-171498.mp3", 1.0, 0);
                break;
        }
        return escribir;
    }

    @FXML
     protected void goMain(){
        clip.stop();
        FXMLLoader loader = new FXMLLoader(PrincipalApplication.class.getResource("jugar.fxml"));
            Parent root;
            try {
                root = loader.load();
            
    
            LoginController registroController = loader.getController();
                registroController.initializate(usuario);
            Stage stage = (Stage) texto.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
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
