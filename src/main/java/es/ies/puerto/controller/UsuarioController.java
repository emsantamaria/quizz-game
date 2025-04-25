package es.ies.puerto.controller;

import java.io.IOException;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.Comodin;
import es.ies.puerto.model.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class UsuarioController {
    @FXML Text textFiled;
    @FXML Text puntaje;
    @FXML Text eliminar;
    @FXML Text completar;
    @FXML Text pista;
    @FXML Text mitad;
    Usuario usuario;

    /**
     * Constructor de la clase `UsuarioController`.
     */
    public UsuarioController() {

    }

    /**
     * Método para inicializar datos previos del usuario.
     */
    public void preInitializate() {

    }

    /**
     * Método para inicializar el controlador con un usuario.
     * @param usuario Usuario que se inicializa.
     */
    public void initializate(Usuario usuario) {
        this.usuario = usuario;
        textFiled.setText(usuario.getNombre());
        puntaje.setText(String.valueOf(usuario.getPuntaje()));

        usuario.getComodines().forEach(comodin -> {
            String cantidadTexto = "Cantidad:" + comodin.getCantidad();
            switch (comodin.getNombre()) {
                case "eliminar1":
                    eliminar.setText(cantidadTexto);
                    break;
                case "completar":
                    completar.setText(cantidadTexto);
                    break;
                case "pista":
                    pista.setText(cantidadTexto);
                    break;
                default:
                    mitad.setText(cantidadTexto);
                    break;
            }
        });
    }

    /**
     * Método para pasar a la pantalla de juego.
     */
    @FXML
    protected void pasarPalabra() {
         FXMLLoader loader = new FXMLLoader(PrincipalApplication.class.getResource("jugar.fxml"));
            Parent root;
            try {
                root = loader.load();
    
            LoginController registroController = loader.getController();
            
           registroController.initializate(usuario);
    
            Stage stage = (Stage) textFiled.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
