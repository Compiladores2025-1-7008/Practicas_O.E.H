/*
 * Universidad Nacional Autónoma de México
 * Facultad de Ciencias
 * Compiladores 2025-1
 * Programa de Análisis Léxico
 * Alumno: Osorio Escandón Huriel
 */

import java.util.ArrayList;
import java.util.List;

// Clase que representa un Token, es decir, cada elemento que el analizador léxico identifica
class Token {
    // Se definen los tipos de tokens que se pueden identificar
    public enum Tipo {
        ID, NUM_ENTERO, NUM_DECIMAL, OPERADOR_ASIGNACION, OPERADOR_SUMA, ESPACIO
    }

    // Tipo del token
    private Tipo tipo;
    
    // Valor del token
    private String valor;

    // Constructor para inicializar un token con su tipo y valor
    public Token(Tipo tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    // Método para obtener el tipo del token
    public Tipo getTipo() {
        return tipo;
    }

    // Método para obtener el valor del token
    public String getValor() {
        return valor;
    }

    // Método para representar el token como cadena
    @Override
    public String toString() {
        return "Token{" +
                "tipo=" + tipo +
                ", valor='" + valor + '\'' +
                '}';
    }
}

// Clase principal que implementa el analizador léxico
public class AnalizadorLexico {

    // Cadena de entrada, es decir, el código fuente a analizar
    private String input;

    // Posición actual dentro de la cadena de entrada
    private int posicion;

    // Constructor para inicializar el analizador con la entrada
    public AnalizadorLexico(String input) {
        this.input = input;

        // De inicio se posiciona en 0
        this.posicion = 0;
    }

    /*
     * Método que regresa el siguiente carácter de la entrada, en dónde, si se llega al final de la entrada,
     * se regresa \0 indicando el fin de la entrada
     */
    private char siguienteCaracter() {
        return posicion < input.length() ? input.charAt(posicion) : '\0';
    }

    // Método que avanza la posición actual en la entrada
    private void avanzar() {
        posicion++;
    }

    // Método que hace el análisis léxico y regresa una lista de tokens
    public List<Token> analizar() {

        // Lista que alamacena los tokens
        List<Token> tokens = new ArrayList<>();

        // Si no se a alcanzado el final de la entrada
        while (posicion < input.length()) {

            // Se obtiene el carácter actual
            char actual = siguienteCaracter();

            // Se ignoran los espacios en blanco
            if (Character.isWhitespace(actual)) {

                // Se avanza sin agregar ningún token
                avanzar();
                continue;
            }

            // Identificadores formados solo por letras
            if (Character.isLetter(actual)) {

                // Se acumula el identificador
                StringBuilder identificador = new StringBuilder();

                // Si es una letra, se sigue acumulando
                while (Character.isLetter(siguienteCaracter())) {
                    identificador.append(siguienteCaracter());
                    avanzar();
                }

                // Se agrega el identificador como un token
                tokens.add(new Token(Token.Tipo.ID, identificador.toString()));
                continue;
            }

            // Números enteros y decimales
            if (Character.isDigit(actual)) {

                // Se acumula el número
                StringBuilder numero = new StringBuilder();

                // Se verifica si el número es decimal
                boolean esDecimal = false;

                // Si es un dígito, se sigue acumulando
                while (Character.isDigit(siguienteCaracter())) {
                    numero.append(siguienteCaracter());
                    avanzar();
                }

                // Se verifica si hay un punto para número decimal
                if (siguienteCaracter() == '.') {

                    // Se define un número decimal
                    esDecimal = true;

                    // Se agrega el punto decimal
                    numero.append('.');
                    avanzar();

                    // Después del punto, deben seguir dígitos
                    while (Character.isDigit(siguienteCaracter())) {
                        numero.append(siguienteCaracter());
                        avanzar();
                    }
                }

                // Se agrega el número como entero o decimal según corresponda
                if (esDecimal) {
                    tokens.add(new Token(Token.Tipo.NUM_DECIMAL, numero.toString()));
                } else {
                    tokens.add(new Token(Token.Tipo.NUM_ENTERO, numero.toString()));
                }
                continue;
            }

            // Operador de asignación =
            if (actual == '=') {

                // Se agrega el token de asignación
                tokens.add(new Token(Token.Tipo.OPERADOR_ASIGNACION, "="));

                // Se avanza para poder procesar al siguiente carácter
                avanzar();
                continue;
            }

            // Operador de suma +
            if (actual == '+') {

                // Se agrega el token de suma
                tokens.add(new Token(Token.Tipo.OPERADOR_SUMA, "+"));

                // Se avanza para poder procesar al siguiente carácter
                avanzar();
                continue;
            }

            // Si se encuentra un carácter no reconocido, se imprime un error
            throw new RuntimeException("Carácter no reconocido: " + actual);
        }

        // Se regresa la lista de tokens encontrados
        return tokens;
    }

    // Método principal para probar el analizador léxico
    public static void main(String[] args) {

        // Código para prueba
        String codigo = "varA = 100 + 25.75 + varB";

        // Se crea una instancia del analizador léxico con el código para prueba
        AnalizadorLexico analizador = new AnalizadorLexico(codigo);

        // Se ejecuta el análisis léxico
        List<Token> tokens = analizador.analizar();

        // Se imprimen los tokens generados
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
