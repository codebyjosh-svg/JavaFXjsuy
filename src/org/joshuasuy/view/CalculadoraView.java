
package org.joshuasuy.view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class CalculadoraView {
    private VBox view;
    private Label pantalla;
    private GridPane cuadroBotones;
    //controller
    
    public CalculadoraView(){
        view = new VBox(15);
        view.setPadding(new Insets(15));
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: #10494F;");
        
        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consola", FontWeight.BOLD, 40));
        pantalla.setAlignment(Pos.CENTER_RIGHT);
        pantalla.setPrefSize(235, 50);
        
        cuadroBotones = new GridPane ();
        cuadroBotones.setHgap(12);
        cuadroBotones.setVgap(12);
        cuadroBotones.setAlignment(Pos.CENTER);//alineado al centro
        
        //crear el primer botton -- instanciar new
        Button btnUno = new Button("1");
        
        //tamaño(ancho y alto)
        btnUno.setPrefSize(50, 50);
        //agregamos un estilo
        btnUno.setStyle("-fx-background-color: #1C7D87; -fx-text-fill:white; -ft-background-radius:5px");
        //al precionarse
        btnUno.setOnMousePressed(e ->{
            //cambiando el fonod
            btnUno.setStyle("-fx-background-color: #24A0AE;");
            //moviendo en el eje Y 2px
            btnUno.setTranslateY(2);
    });
        //al soltar el click
        btnUno.setOnMouseReleased(e -> {
            //retornar el color de fondo al original
            btnUno.setStyle("-fx-background-color: #1C7D87;");
            btnUno.setTranslateY(0);
        });
        
        btnUno.setFont(Font.font("Consolas", FontWeight.BOLD, 20));
        
          Button btnDos = new Button("2");
        btnDos.setPrefSize(50, 50);
        btnDos.setStyle("-fx-background-color: #1C7D87; -fx-text-fill:white; -ft-background-radius:5px");
            btnDos.setOnMousePressed(e -> {
            btnDos.setStyle("-fx-background-color: #24A0AE;");
            btnDos.setTranslateY(2);
    });   
        btnDos.setOnMouseReleased(e -> {
            btnDos.setStyle("-fx-background-color: #1C7D87;");
            btnDos.setTranslateY(0);    

        });
        
        btnDos.setFont(Font.font("Consolas", FontWeight.BOLD, 20));
        
        
          Button btnTres = new Button("3");
        btnTres.setPrefSize(50, 50);
        btnTres.setStyle("-fx-background-color: #1C7D87; -fx-text-fill:white; -ft-background-radius:5px");
            btnTres.setOnMousePressed(e -> {
            btnTres.setStyle("-fx-background-color: #24A0AE;");
            btnTres.setTranslateY(2);
            });        
        btnTres.setOnMouseReleased(e -> {
            btnTres.setStyle("-fx-background-color: #1C7D87;");
            btnTres.setTranslateY(0);      
            });
        btnTres.setFont(Font.font("Consolas", FontWeight.BOLD, 20));
        
        Button btnMas = new Button("+");
        btnMas.setPrefSize(50, 50);
        
        
        //agregarlo al cuadroBotones
        cuadroBotones.add(btnUno, 0, 3);
        cuadroBotones.add(btnDos, 1, 3);
        cuadroBotones.add(btnTres, 2, 3);
        cuadroBotones.add(btnMas, 3, 3);
        
        view.getChildren().addAll(pantalla,cuadroBotones);
    }
    public VBox getView(){
        return view;
    }
    
    private Button nuevoBoton(String texto){
        
        Button btn = new Button(texto);
        
        
        //configuracion de boton
        //tamaño, el estilo, sus funciones
        return btn;
    }
}
