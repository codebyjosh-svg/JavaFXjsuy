
package org.joshuasuy.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
  
    public static void main(String[] args){
        System.out.println("Hola Mundo");
        launch(args);
    }
    
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        //nodos
        VBox raiz = new VBox();
        
        //scena
        Scene escena = new Scene(raiz);
        
        //cargar escena y mostrar escenario principal
        escenarioPrincipal.setTitle("Calculador de Joshua");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
        
    }
}
