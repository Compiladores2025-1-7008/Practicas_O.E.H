package main.java;

public class ClaseLexica {

    // Definición de clases léxicas utilizando enteros
    public static final int INT = 1;
    public static final int FLOAT = 2;
    public static final int IF = 3;
    public static final int ELSE = 4;
    public static final int WHILE = 5;
    public static final int NUMERO = 6;
    public static final int ID = 7;
    public static final int PYC = 8; // Punto y coma
    public static final int COMA = 9; // Coma
    public static final int LPAR = 10; // Paréntesis izquierdo
    public static final int RPAR = 11; // Paréntesis derecho
    public static final int EQUAL = 12; // Igual (=)
    public static final int PLUS = 13; // Suma (+)
    public static final int MINUS = 14; // Resta (-)
    public static final int TIMES = 15; // Multiplicación (*)
    public static final int DIV = 16; // División (/)

    // Método opcional para obtener una representación en cadena del valor de la clase léxica
    public static String toString(int clase) {
        switch (clase) {
            case INT:
                return "INT";
            case FLOAT:
                return "FLOAT";
            case IF:
                return "IF";
            case ELSE:
                return "ELSE";
            case WHILE:
                return "WHILE";
            case NUMERO:
                return "NUMERO";
            case ID:
                return "ID";
            case PYC:
                return "PYC";
            case COMA:
                return "COMA";
            case LPAR:
                return "LPAR";
            case RPAR:
                return "RPAR";
            default:
                return "UNKNOWN";
        }
    }
}
