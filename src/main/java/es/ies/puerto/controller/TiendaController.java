package es.ies.puerto.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.Comodin;
import es.ies.puerto.model.Usuario;
import es.ies.puerto.model.Usuarios;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
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
public class TiendaController {
    @FXML Text textCompletar;
    @FXML Text textMedia;
    @FXML Text textPista;
    @FXML Text textEliminar1;
    @FXML Text puntos;
    Usuario usuario;
    Usuarios usurios;
    @FXML Button completar;
    @FXML Button pista;
    @FXML Button mediaEliminacion;
    @FXML Button eliminar1;
    List<Button>listButtton;
    List<Text>listText;
    AudioClip clip;
    public TiendaController(){
usurios=new Usuarios();
    }
    public void initializate(Usuario usuario){
        play("supermarket-background-noise-and-casheer-130904.mp3", 1.0, 0);
        listButtton=new ArrayList<>(Arrays.asList(completar,pista,mediaEliminacion,eliminar1));
        listText=new ArrayList<>(Arrays.asList(textCompletar,textEliminar1,textMedia,textPista));
        this.usuario=usuario;
        puntos.setText("Tus puntos: "+usuario.getPuntaje());
    }

    @FXML
    protected void jugar(ActionEvent event){
        clip.stop();
        Button button=(Button)event.getSource();
        int coste=0;
        switch (button.getId()) {
            case "pista":
               coste=30;
                break;
            case "completar":
                coste=190;
                 break;
            case "mediaEliminacion":
                coste=120;
                 break;
                default:
                coste=60;
        }
        if(coste>usuario.getPuntaje()){
            return;
        }
        coste=-coste;
        usuario.actualizarPuntuacion(coste);
        play("cashier-quotka-chingquot-sound-effect-129698.mp3", 1.0, 0);
        puntos.setText("Tus puntos:"+usuario.getPuntaje());
        for (Comodin comodin : usuario.getComodines()) {
            if(comodin.getNombre().equals(button.getId())){
                comodin.setCantidad(comodin.getCantidad()+1);
                usurios.upadte(usuario);
            }
        }
        initializate(usuario);
    }

    @FXML
    protected void goBack(){
        clip.stop();
         FXMLLoader loader = new FXMLLoader(PrincipalApplication.class.getResource("jugar.fxml"));
            Parent root;
            try {
                root = loader.load();
            
    
            LoginController registroController = loader.getController();
            registroController.initializate(usuario);
            
            Stage stage = (Stage) textCompletar.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void play(String soundFile, double volume, double delaySeconds) {
        try {
            //AudioClip clip = new AudioClip(SoundPlayer.class.getResource("/sounds/" + soundFile).toExternalForm());

            File file = new File("" + soundFile);
            URL url=getClass().getResource("/sounds/"+file);
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
