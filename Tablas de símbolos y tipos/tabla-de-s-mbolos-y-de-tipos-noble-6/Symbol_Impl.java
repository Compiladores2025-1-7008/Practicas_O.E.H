/*
 * Universidad Nacional Autónoma de México
 * Facultad de Ciencias
 * Compiladores 2025-1
 * Tablas de símbolos y tipos
 * 
 * Alumno: Osorio Escandón Huriel
 * Correo: Huriel117@ciencias.unam.mx
 * Número de cuenta: 317204652
 */

import java.util.ArrayList;

public class Symbol_Impl implements Symbol {
    // Dirección del símbolo
    private int dir;

    // Tipo del símbolo
    private int type;

    // Categoría del símbolo
    private String cat;

    // Lista de argumentos del símbolo
    private ArrayList<Integer> args;

    // Constructor
    public Symbol_Impl(int dir, int type, String cat, ArrayList<Integer> args) {
        this.dir = dir;
        this.type = type;
        this.cat = cat;
        this.args = args;
    }

    // Métodos de la interfaz Symbol

    // Método getDir que regresa la dirección del símbolo
    @Override
    public int getDir() {
        return dir;
    }

    // Método getType que regresa el tipo del símbolo
    @Override
    public int getType() {
        return type;
    }

    // Método getCat que regresa la categoría del símbolo
    @Override
    public String getCat() {
        return cat;
    }

    // Método getArgs que regresa la lista de argumentos del símbolo
    @Override
    public ArrayList<Integer> getArgs() {
        return args;
    }
}