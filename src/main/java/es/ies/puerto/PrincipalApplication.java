package es.ies.puerto;

import java.io.IOException;

import es.ies.puerto.controller.PrincipalController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalApplication extends Application {
    /**
     * Método principal de inicio de la aplicación.
     * @param stage Escenario principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 740);
        PrincipalController pc=new PrincipalController();

        stage.setTitle("Pantalla Princial");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal para lanzar la aplicación.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}