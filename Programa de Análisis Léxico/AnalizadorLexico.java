import java.util.ArrayList;
import java.util.List;

// Clase que representa un Token (cada elemento que el analizador léxico identifica)
class Token {
    // Definimos los tipos de tokens que se pueden identificar
    public enum Tipo {
        IDENTIFICADOR, NUMERO_ENTERO, NUMERO_DECIMAL, OPERADOR_ASIGNACION, OPERADOR_SUMA, ESPACIO
    }

    private Tipo tipo; // Tipo del token (identificador, número, operador, etc.)
    private String valor; // Valor del token (por ejemplo, "x", "=", "12")

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

    // Método para representar el token como cadena (útil para imprimir)
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
    private String input; // Cadena de entrada (el código fuente a analizar)
    private int posicion; // Posición actual dentro de la cadena de entrada

    // Constructor para inicializar el analizador con la entrada
    public AnalizadorLexico(String input) {
        this.input = input;
        this.posicion = 0; // Inicialmente, comenzamos en la posición 0
    }

    // Método que retorna el siguiente carácter de la entrada
    // Si llegamos al final de la entrada, retorna '\0' (indica fin de entrada)
    private char siguienteCaracter() {
        return posicion < input.length() ? input.charAt(posicion) : '\0';
    }

    // Método que avanza la posición actual en la entrada
    private void avanzar() {
        posicion++;
    }

    // Método que realiza el análisis léxico y retorna una lista de tokens
    public List<Token> analizar() {
        List<Token> tokens = new ArrayList<>(); // Lista donde almacenaremos los tokens

        // Mientras no hayamos alcanzado el final de la entrada
        while (posicion < input.length()) {
            char actual = siguienteCaracter(); // Obtenemos el carácter actual

            // Ignorar espacios en blanco
            if (Character.isWhitespace(actual)) {
                avanzar(); // Simplemente avanzamos sin agregar ningún token
                continue;
            }

            // Identificadores (formados solo por letras)
            if (Character.isLetter(actual)) {
                StringBuilder identificador = new StringBuilder(); // Acumulamos el identificador
                // Mientras sea una letra, seguimos acumulando
                while (Character.isLetter(siguienteCaracter())) {
                    identificador.append(siguienteCaracter());
                    avanzar();
                }
                // Añadimos el identificador como un token
                tokens.add(new Token(Token.Tipo.IDENTIFICADOR, identificador.toString()));
                continue;
            }

            // Números (enteros y decimales)
            if (Character.isDigit(actual)) {
                StringBuilder numero = new StringBuilder(); // Acumulamos el número
                boolean esDecimal = false; // Para verificar si el número es decimal

                // Mientras sea un dígito, seguimos acumulando
                while (Character.isDigit(siguienteCaracter())) {
                    numero.append(siguienteCaracter());
                    avanzar();
                }

                // Verificamos si hay un punto para número decimal
                if (siguienteCaracter() == '.') {
                    esDecimal = true; // Es un número decimal
                    numero.append('.'); // Añadimos el punto decimal
                    avanzar();

                    // Después del punto, deben seguir dígitos
                    while (Character.isDigit(siguienteCaracter())) {
                        numero.append(siguienteCaracter());
                        avanzar();
                    }
                }

                // Añadimos el número como entero o decimal según corresponda
                if (esDecimal) {
                    tokens.add(new Token(Token.Tipo.NUMERO_DECIMAL, numero.toString()));
                } else {
                    tokens.add(new Token(Token.Tipo.NUMERO_ENTERO, numero.toString()));
                }
                continue;
            }

            // Operador de asignación '='
            if (actual == '=') {
                tokens.add(new Token(Token.Tipo.OPERADOR_ASIGNACION, "=")); // Añadimos el token de asignación
                avanzar(); // Avanzamos para procesar el siguiente carácter
                continue;
            }

            // Operador de suma '+'
            if (actual == '+') {
                tokens.add(new Token(Token.Tipo.OPERADOR_SUMA, "+")); // Añadimos el token de suma
                avanzar(); // Avanzamos para procesar el siguiente carácter
                continue;
            }

            // Si encontramos un carácter que no reconocemos, lanzamos un error
            throw new RuntimeException("Carácter no reconocido: " + actual);
        }

        return tokens; // Retornamos la lista de tokens encontrados
    }

    // Método principal para probar el analizador léxico
    public static void main(String[] args) {
        // Código de prueba
        String codigo = "x = 12 + 5.5";

        // Creamos una instancia del analizador léxico con el código de prueba
        AnalizadorLexico analizador = new AnalizadorLexico(codigo);

        // Ejecutamos el análisis léxico
        List<Token> tokens = analizador.analizar();

        // Imprimimos los tokens generados
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
