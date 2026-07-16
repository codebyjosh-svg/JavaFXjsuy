package org.joshuasuy.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.joshuasuy.view.CalculadoraView;

public class Main extends Application {

    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        launch(args);
    }
    private Scene escena;

    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        //vista de la calculadora 
        CalculadoraView calculadora = new CalculadoraView();
        //nodos
        Pane raiz = new Pane(calculadora.getView());

        //esecna(ndodRaiz, ancho, largo)
        Scene escena = new Scene(raiz, 266, 390);

        //cargar escene y mostrar escenario principal 
        escenarioPrincipal.setTitle("Calculadora de Joshua");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }
}
