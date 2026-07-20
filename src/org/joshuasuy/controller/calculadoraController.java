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
    if (entrada.equals("C")) {
        opcion1 = "";
        operador = "";
        opcion2 = "";
        pantalla.setText("");
        return;
    }
    calculoTerminado = false;

    if (entrada.matches("[0-9]")) {
        if (operador.isEmpty() || operador.equals("\u221A") || operador.equals("%")) {
            opcion1 += entrada;
        } else {
            opcion2 += entrada;
        }
        actualizarPantalla(pantalla);

    } else if (entrada.equals("+") || entrada.equals("-") || entrada.equals("*") || entrada.equals("/") || entrada.equals("^")) {
        operador = entrada;
        actualizarPantalla(pantalla);

    } else if (entrada.equals("\u221A")) {
        operador = "\u221A";
        actualizarPantalla(pantalla);
        
    }else if (entrada.equals("%")){
        operador ="%";
        actualizarPantalla(pantalla);

    } else if (entrada.equals("=")) {
        if (operador.equals("\u221A") && !opcion1.isEmpty()) {
            opcion1 = resultadoRaiz(opcion1);
            operador = "";
            opcion2 = "";
            calculoTerminado = true;
            
        }else if (operador.equals("%") && !opcion1.isEmpty()){
            opcion1 = resultadoPorcentaje(opcion1);
            operador = "";
            opcion2 = "";
            calculoTerminado =true;

        } else if (!opcion1.isEmpty() && !opcion2.isEmpty()) {
            if (operador.equals("+")) {
                opcion1 = resultadoSuma(opcion1, opcion2);
            } else if (operador.equals("-")) {
                opcion1 = resultadoResta(opcion1, opcion2);
            } else if (operador.equals("*")) {
                opcion1 = resultadoMultiplicacion(opcion1, opcion2);
            } else if (operador.equals("/")) {
                if (opcion2.equals("0")) {
                    opcion1 = "ERROR";
                } else {
                    opcion1 = resultadoDivision(opcion1, opcion2);
                }
            }else if (operador.equals("^")){
                opcion1 = resultadoPotencia(opcion1, opcion2);
            }
            operador = "";
            opcion2 = "";
            calculoTerminado = true;
        }
        actualizarPantalla(pantalla);
    }
}
  
 private void actualizarPantalla(Label pantalla) {
    if (operador.equals("\u221A")) {
        pantalla.setText("\u221A" + opcion1);
    }else if (operador.equals("%")){
        pantalla.setText(opcion1 + "%");
    } else if (operador.isEmpty()) {
        pantalla.setText(opcion1);
    } else {
        pantalla.setText(opcion1 + " " + operador + " " + opcion2);
    }
}

private String resultadoSuma(String numeroUno, String numeroDos) {
    int datoUno = Integer.parseInt(numeroUno);
    int datoDos = Integer.parseInt(numeroDos);
    int suma = datoUno + datoDos;
    return String.valueOf(suma);
}

private String resultadoResta(String numeroUno, String numeroDos) {
    int datoUno = Integer.parseInt(numeroUno);
    int datoDos = Integer.parseInt(numeroDos);
    int resta = datoUno - datoDos;
    return String.valueOf(resta);
}

private String resultadoMultiplicacion(String numeroUno, String numeroDos) {
    int datoUno = Integer.parseInt(numeroUno);
    int datoDos = Integer.parseInt(numeroDos);
    int multiplicacion = datoUno * datoDos;
    return String.valueOf(multiplicacion);
}


private String resultadoDivision(String numeroUno, String numeroDos) {
    int datoUno = Integer.parseInt(numeroUno);
    int datoDos = Integer.parseInt(numeroDos);
    int division = datoUno / datoDos;
    return String.valueOf(division);
}

    private String resultadoRaiz(String numeroUno) {
       int datoUno = Integer.parseInt(numeroUno);
       double raiz = Math.sqrt(datoUno);
       return String.valueOf(raiz);
       
    }
    
    private String resultadoPotencia(String numeroUno, String numeroDos){
        int datoUno = Integer.parseInt(numeroUno);
        int datoDos = Integer.parseInt(numeroDos);
        double potencia = Math.pow(datoUno, datoDos);
        return String.valueOf(potencia);
    }
    
    private String resultadoPorcentaje(String numeroUno){
        int datoUno = Integer.parseInt(numeroUno);
        double porcentaje = datoUno / 100.0;
        return String.valueOf(porcentaje);
    }
}
