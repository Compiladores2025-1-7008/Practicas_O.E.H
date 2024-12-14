/*
  Universidad Nacional Autónoma de México
  Facultad de Ciencias
  Compiladores 2025-1
  Osorio Escandón Huriel
  Huriel117@ciencias.unam.mx 
  317204652
*/

%{
  import java.io.*;  // Importa las clases necesarias para la lectura de archivos y manejo de entradas
%}

%token LETRA DIGITO VAR  // Definición de tokens: LETRA, DIGITO y VAR

%%

s : expr  // La regla principal 's' puede ser una expresión
  | asig  // o una asignación
  ;

asig : VAR var "=" expr  // Una asignación consta de un token VAR, una variable, el signo '=' y una expresión
     ;

expr : term expr1  // Una expresión consta de un término seguido de 'expr1'
     ;

expr1 : '+' term expr1  // 'expr1' puede ser una adición
      | '-' term expr1  // o una sustracción
      | /* epsilon */  // o puede ser vacío (epsilon)
      ;

term : factor term1  // Un término consiste en un factor seguido de 'term1'
     ;

term1 : '*' factor term1  // 'term1' puede ser una multiplicación
      | '/' factor term1  // o una división
      | /* epsilon */  // o vacío (epsilon)
      ;

factor : num  // Un factor puede ser un número
       | var  // o una variable
       | '(' expr ')'  // o una expresión entre paréntesis
       | '-' factor  // o un factor precedido por un signo negativo
       ;

num : entero decimal  // Un número se compone de un entero seguido de un decimal (opcional)
    ;

decimal : '.' entero  // Un decimal es un punto seguido de un entero
        | /* epsilon */  // o puede ser vacío (epsilon)
        ;

entero : DIGITO  // Un entero consta de un dígito
       | DIGITO entero  // o de uno o más dígitos
       ;

var : LETRA pos  // Una variable consta de una letra seguida de 'pos'
    ;

pos : var  // 'pos' puede ser otra variable
    | /* epsilon */  // o vacío (epsilon)
    ;

%%

  private Yylex lexer;  // Declaración del lexer (analizador léxico)

  // Función que invoca al lexer para obtener el siguiente token
  private int yylex () {
    int yyl_return = -1;
    try {
      yyl_return = lexer.yylex();  // Llama a la función yylex del lexer
    }
    catch (IOException e) {
      System.err.println("IO error :"+e);  // Maneja errores de entrada/salida
    }
    return yyl_return;  // Retorna el token obtenido
  }

  // Función que maneja los errores de sintaxis
  public void yyerror (String error) {
    System.err.println ("Error: " + error);  // Muestra el mensaje de error
  }

  // Constructor del parser que inicializa el lexer con un archivo de entrada
  public Parser(Reader r) {
    lexer = new Yylex(r, this);  // Inicializa el lexer con el Reader y una referencia al parser
  }

  // Método principal para parsear el archivo de entrada
  public static void main(String args[]) throws IOException {
    System.out.println("Gramatica con BYACC/Java");

    // Crea una instancia del parser pasando el archivo de entrada como parámetro
    Parser yyparser = new Parser(new FileReader(args[0]));;

    // Llama a la función de parseo para analizar la entrada
    yyparser.yyparse();
  }
