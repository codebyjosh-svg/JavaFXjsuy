
package org.joshuasuy.view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.joshuasuy.controller.calculadoraController;


public class CalculadoraView {
    private VBox view;
    private Label pantalla;
    private GridPane cuadroBotones;
    //controller
    private calculadoraController controller;
    
    public CalculadoraView(){
        controller = new calculadoraController();
        
        //Contenedor principal, usado como nodo raiz
        view = new VBox(15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER_LEFT);
        view.setStyle("-fx-background-color: #10494F;");
        
        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consola", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(235, 50);
        pantalla.setStyle("-fx-background-color: #9EE3EB;");
        
        cuadroBotones = new GridPane ();
        cuadroBotones.setHgap(12);
        cuadroBotones.setVgap(12);
        cuadroBotones.setAlignment(Pos.CENTER);//alineado al centro
        
        //crear el primer botton -- instanciar new
        Button btnUno = nuevoBoton("1");
          Button btnDos = nuevoBoton("2");
          Button btnTres = nuevoBoton("3");
          Button btnMas = nuevoBoton("+");
          Button btnIgual = nuevoBoton("=");
          Button btnClear = nuevoBoton("C");
        
        //agregarlo al cuadroBotones
         cuadroBotones.add(btnUno, 0, 3);
         cuadroBotones.add(btnDos, 1, 3);
         cuadroBotones.add(btnTres, 2, 3);
         cuadroBotones.add(btnMas, 3, 3);
         cuadroBotones.add(btnIgual, 3, 4);
        cuadroBotones.add(btnClear, 0, 4);
        
        view.getChildren().addAll(pantalla, cuadroBotones);
    }
    public VBox getView(){
        return view;
    }
    
    private Button nuevoBoton(String texto){
        
        Button btn = new Button(texto);
        //configuracion de boton
        //tamaño, el estilo, sus funciones
        btn.setPrefSize(50, 50);
        btn.setStyle("-fx-background-color: #1C7D87; -fx-text-fill: white; -fx-background-radius:5px; -fx-cursor: hand;");
        
        btn.setOnMousePressed(e -> {
    btn.setStyle("-fx-background-color: #24A0AE; -fx-text-fill: white; -fx-background-radius:5px; -fx-cursor: hand;");
    btn.setTranslateY(2);
});

btn.setOnMouseReleased(e -> {
    btn.setStyle("-fx-background-color: #1C7D87; -fx-text-fill: white; -fx-background-radius:5px; -fx-cursor: hand;");
    btn.setTranslateY(0);
});
    
        btn.setOnAction(e -> controller.procesoDeEntrada(texto, pantalla));
        return btn;
    }
}
