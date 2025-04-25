package es.ies.puerto.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import es.ies.puerto.PrincipalApplication;
import es.ies.puerto.model.Comodin;
import es.ies.puerto.model.Usuario;
import es.ies.puerto.model.Usuarios;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * @version 1.0.0
 * @author emsantamaria
 */
public class RegisterController {
    @FXML TextField textFiled;
    Usuarios usuarios;

    /**
     * Método para registrar un nuevo usuario y asignarle comodines.
     */
    @FXML
    protected void pasarPalabra() {
        if (textFiled == null || textFiled.getText().isBlank()) {
            return;
        }

        usuarios = new Usuarios();
        if (usuarios.findByName(textFiled.getText()) != null) {
            return;
        }

        Usuario usuario = new Usuario(textFiled.getText(), 0);
        usuarios.aniadir(usuario);

        List<Comodin> comodines = Arrays.asList(
            new Comodin(usuario.getId(), 0, "eliminar1"),
            new Comodin(usuario.getId(), 0, "completar"),
            new Comodin(usuario.getId(), 0, "mediaEliminacion"),
            new Comodin(usuario.getId(), 0, "pista")
        );

        usuario.setComodines(comodines);
        usuarios.upadte(usuario);
        go(usuario);
    }

    /**
     * Método para iniciar el juego con un usuario registrado.
     * @param usuario Usuario registrado.
     */
    public void go(Usuario usuario){
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
