package main.java;

import java.io.IOException;
import main.jflex.Lexer;

public class Parser implements ParserInterface {
    private Lexer lexer;
    private int actual;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public void eat(int claseLexica) {
        if (actual == claseLexica) {
            try {
                actual = lexer.yylex();
                System.out.println("Consumiendo token: " + claseLexica); // Mensaje para debug
            } catch (IOException ioe) {
                System.err.println("Failed to read next token");
            }
        } else {
            error("Se esperaba el token: " + claseLexica);
        }
    }

    public void error(String msg) {
        System.err.println("ERROR DE SINTAXIS: " + msg + " en la línea " + lexer.getLine());
    }

    public void parse() {
        try {
            this.actual = lexer.yylex();
            S(); // Llama al símbolo inicial
            if (actual == 0) // llegamos al EOF sin error
                System.out.println("La cadena es aceptada");
            else
                System.out.println("La cadena no pertenece al lenguaje generado por la gramática");
        } catch (IOException ioe) {
            System.err.println("Error: No fue posible obtener el primer token de la entrada.");
            System.exit(1);
        }
    }

    public void S() { // S() = programa()
        declaraciones();
        sentencias();
    }

    public void declaraciones() {
        while (actual == ClaseLexica.INT || actual == ClaseLexica.FLOAT) {
            declaracion(); // Procesar cada declaración
        }
    }

    public void declaracion() {
        if (actual == ClaseLexica.INT) {
            eat(ClaseLexica.INT); // Consumir tipo
        } else if (actual == ClaseLexica.FLOAT) {
            eat(ClaseLexica.FLOAT); // Consumir tipo
        }
        
        lista_var(); // Procesar la lista de variables
        eat(ClaseLexica.PYC); // Consumir punto y coma
    }

    public void lista_var() {
        eat(ClaseLexica.ID); // Consumir identificador
        while (actual == ClaseLexica.COMA) { // Mientras haya más identificadores
            eat(ClaseLexica.COMA); // Consumir la coma
            eat(ClaseLexica.ID); // Consumir el siguiente identificador
        }
    }

    public void sentencias() {
        while (actual != 0) { // Mientras no sea EOF
            if (actual == ClaseLexica.ID) {
                eat(ClaseLexica.ID); // Consumir identificador
                eat(ClaseLexica.EQUAL); // Consumir igual
                expresion(); // Manejar la expresión
                eat(ClaseLexica.PYC); // Consumir punto y coma
            } else if (actual == ClaseLexica.IF) {
                eat(ClaseLexica.IF);
                eat(ClaseLexica.LPAR);
                expresion(); // Manejar condición
                eat(ClaseLexica.RPAR);
                sentencias(); // Sentencias dentro del if
                if (actual == ClaseLexica.ELSE) {
                    eat(ClaseLexica.ELSE);
                    sentencias(); // Sentencias dentro del else
                }
            } else if (actual == ClaseLexica.WHILE) {
                eat(ClaseLexica.WHILE);
                eat(ClaseLexica.LPAR);
                expresion(); // Manejar condición
                eat(ClaseLexica.RPAR);
                sentencias(); // Sentencias dentro del while
            } else {
                error("Token no esperado: " + actual);
                break; // Salir si encontramos un token no esperado
            }
        }
    }

    public void expresion() {
        // Implementa aquí la lógica para manejar expresiones
        // Ejemplo básico:
        if (actual == ClaseLexica.ID || actual == ClaseLexica.NUMERO) {
            eat(actual); // Consumir identificador o número
            while (actual == ClaseLexica.PLUS || actual == ClaseLexica.MINUS ||
                   actual == ClaseLexica.TIMES || actual == ClaseLexica.DIV) {
                eat(actual); // Consumir operador
                if (actual == ClaseLexica.ID || actual == ClaseLexica.NUMERO) {
                    eat(actual); // Consumir identificador o número
                } else {
                    error("Se esperaba un identificador o número");
                }
            }
        } else if (actual == ClaseLexica.LPAR) {
            eat(ClaseLexica.LPAR);
            expresion(); // Manejar expresiones dentro de paréntesis
            eat(ClaseLexica.RPAR);
        } else {
            error("Se esperaba una expresión válida");
        }
    }
}
