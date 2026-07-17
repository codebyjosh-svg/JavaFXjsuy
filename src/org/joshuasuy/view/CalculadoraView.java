
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
        view.setPadding(new Insets(20));
        view.setAlignment(Pos.CENTER_LEFT);
        view.setStyle("-fx-background-color: #10494F;");
        
        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consola", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(250, 70);
        pantalla.setStyle("-fx-background-color: #9EE3EB;");
        
        cuadroBotones = new GridPane ();
        cuadroBotones.setHgap(12);
        cuadroBotones.setVgap(12);
        cuadroBotones.setAlignment(Pos.CENTER);//alineado al centro
        
        //crear el primer botton -- instanciar new
        //fila 0: Nuevos operadores y Division
        Button btnRaiz = nuevoBoton("√");
        Button btnPot = nuevoBoton("^");
        Button btnPorc = nuevoBoton("%");
        Button btnDiv = nuevoBoton("/");

        cuadroBotones.add(btnRaiz, 0, 0);
        cuadroBotones.add(btnPot, 1, 0);
        cuadroBotones.add(btnPorc, 2, 0);
        cuadroBotones.add(btnDiv, 3, 0);

        //Fila 1: Numeros y multiplicacion
          Button btnSiete = nuevoBoton("7");
        Button btnOcho = nuevoBoton("8");
        Button btnNueve = nuevoBoton("9");
        Button btnMult = nuevoBoton("*");

        cuadroBotones.add(btnSiete, 0, 1);
        cuadroBotones.add(btnOcho, 1, 1);
        cuadroBotones.add(btnNueve, 2, 1);
        cuadroBotones.add(btnMult, 3, 1);
        
        //Fila 2: Numeros y menos
        Button btnCuatro = nuevoBoton("4");
        Button btnCinco = nuevoBoton("5");
        Button btnSeis = nuevoBoton("6");
        Button btnMenos = nuevoBoton("-");
        
        cuadroBotones.add(btnCuatro, 0, 2);
        cuadroBotones.add(btnCinco, 1, 2);
        cuadroBotones.add(btnSeis, 2, 2);
        cuadroBotones.add(btnMenos, 3, 2);
        
        //fila 3:  Numeros y suma
        Button btnUno = nuevoBoton("1");
        Button btnDos = nuevoBoton("2");
        Button btnTres = nuevoBoton("3");
        Button btnMas = nuevoBoton("+");

        cuadroBotones.add(btnUno, 0, 3);
        cuadroBotones.add(btnDos, 1, 3);
        cuadroBotones.add(btnTres, 2, 3);
        cuadroBotones.add(btnMas, 3, 3);

        //fila 4: Limpiar, Cero y el boton Igual
        Button btnIgual = nuevoBoton("=");
        Button btnClear = nuevoBoton("C");
        Button btnCero = nuevoBoton("0");
        
        btnIgual.setPrefSize(115, 55);
        GridPane.setColumnSpan(btnIgual, 2);

        cuadroBotones.add(btnIgual, 2, 4);
        cuadroBotones.add(btnClear, 0, 4);
        cuadroBotones.add(btnCero, 1, 4);

          
        //agregarlo al cuadroBotones
        
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
