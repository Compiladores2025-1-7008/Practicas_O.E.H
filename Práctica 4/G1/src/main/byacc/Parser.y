/*
  Universidad Nacional Autónoma de México
  Facultad de Ciencias
  Compiladores 2025-1
  Osorio Escandón Huriel
  Huriel117@ciencias.unam.mx 
  317204652
*/

%{
  import java.io.*;  // Importa las clases necesarias para la lectura de archivos
%}

%token LETRA DIGITO VAR  // Definición de los tokens: LETRA (letras), DIGITO (dígitos numéricos) y VAR (variables)

%%

s : expr | asig;  // La regla principal de la gramática puede ser una expresión (expr) o una asignación (asig)

expr : term expr1;  // Una expresión consiste en un término (term) seguido de una continuación de expresión (expr1)
expr1 : '+' term expr1  // Continuación de una expresión con adición
       | '-' term expr1  // Continuación de una expresión con sustracción
       | /* epsilon */;  // O puede ser vacío (epsilon), es decir, la expresión puede terminar aquí
term : factor term1;  // Un término consiste en un factor seguido de una continuación de término (term1)
term1 : '*' factor term1  // Continuación de un término con multiplicación
       | '/' factor term1  // Continuación de un término con división
       | /* epsilon */;  // O puede ser vacío (epsilon), es decir, el término puede terminar aquí
factor : num  // Un factor puede ser un número
       | var  // O una variable
       | '(' expr ')'  // O una expresión entre paréntesis
       | '-' expr;  // O una expresión precedida por un signo negativo
num : entero decimal;  // Un número se compone de un entero seguido de un decimal (opcional)
decimal : '.' entero  // Un decimal es un punto seguido de un entero
        | /* epsilon */;  // O puede ser vacío (epsilon), es decir, no tener decimal
entero : DIGITO  // Un entero puede ser un solo dígito
       | DIGITO entero;  // O puede ser un dígito seguido de más dígitos
asig : VAR var "=" expr;  // Una asignación consiste en una variable (VAR), una variable (var), un signo igual y una expresión
var : LETRA pos;  // Una variable consiste en una letra seguida de una posición (pos)
pos : var  // Una posición puede ser otra variable
    | /* epsilon */;  // O puede ser vacío (epsilon), es decir, la variable no tiene una posición adicional

%%

  private Yylex lexer;  // Declaración del lexer (analizador léxico)

  // Función que invoca el lexer para obtener el siguiente token
  private int yylex () {
    int yyl_return = -1;
    try {
      yyl_return = lexer.yylex();  // Llama a la función yylex del lexer para obtener el siguiente token
    }
    catch (IOException e) {
      System.err.println("IO error :" + e);  // Manejo de errores de entrada/salida si ocurre algún problema
    }
    return yyl_return;  // Retorna el token obtenido por el lexer
  }

  // Función que maneja los errores de sintaxis durante el análisis
  public void yyerror (String error) {
    System.err.println ("Error: " + error);  // Imprime el mensaje de error en caso de error de sintaxis
  }

  // Constructor del parser que inicializa el lexer con un archivo de entrada
  public Parser(Reader r) {
    lexer = new Yylex(r, this);  // Inicializa el lexer con el archivo de entrada y una referencia al parser
  }

  // Método principal que se ejecuta para parsear el archivo de entrada
  public static void main(String args[]) throws IOException {
    System.out.println("Gramatica con BYACC/Java");

    // Crea una instancia del parser pasando el archivo de entrada como parámetro
    Parser yyparser = new Parser(new FileReader(args[0]));  // Abre el archivo de entrada especificado como argumento

    // Llama a la función de parseo para analizar la entrada
    yyparser.yyparse();  // Inicia el proceso de análisis sintáctico
  }
