package org.joshuasuy.controller;

import javafx.scene.control.Label;

public class calculadoraController {

    private String opcion1 = "";
    private String operador = "";
    private String opcion2 = "";
    private boolean calculoTerminado = false;

    public calculadoraController() {

    }

    public void procesoDeEntrada(String entrada, Label pantalla) {
        if (entrada.equals("C")){
            opcion1 = "";
            operador = "";
            opcion2 = "";
            pantalla.setText("")    ;
         }
        
        //si ya se completo un calculo // reiniciar
        if(calculoTerminado && entrada.matches("[0-9]")){
            opcion1 = "";
            operador = "";
            opcion2 = "";
        }
        calculoTerminado = false;

        if (entrada.matches("[0-9]")) {
            if (operador.isEmpty()) {
                opcion1 += entrada;
            } else {
                opcion2 += entrada;
            }

            actualizarPantalla(pantalla);
        } else if (entrada.equals("+")) {
            operador = entrada;
            actualizarPantalla(pantalla);
        } else if (entrada.equals("=")) {
            if (operador.equals("+")) {
                opcion1 = resultadoSuma(opcion1, opcion2);
                operador = "";
                opcion2 = "";
                calculoTerminado = true;
            }
            actualizarPantalla(pantalla);
        }

    }

    private void actualizarPantalla(Label pantalla) {
        if (operador.isEmpty()) {
            pantalla.setText(opcion1);
        } else {
            pantalla.setText(opcion1 + " " + operador + " " + opcion2);
        }
    }

    private String resultadoSuma(String numeroUno, String numeroDos) {
        String resultado;
        int datoUno = Integer.parseInt(opcion1);
        int datoDos = Integer.parseInt(opcion2);
        int suma = datoUno + datoDos;

        return resultado = String.valueOf(suma);
    }

}
