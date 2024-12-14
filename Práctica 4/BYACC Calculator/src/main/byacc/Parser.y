/* 
   Universidad Nacional Autónoma de México
   Facultad de Ciencias
   Compiladores 2025-1
   Osorio Escandón Huriel
   Huriel117@ciencias.unam.mx 
   317204652
*/

%{
  /* Importamos la librería para manejo de entrada y salida */
  import java.io.*;
%}
      
%token NL          /* Token para nueva línea */
%token <dval> NUM  /* Token para números; usa 'dval' como atributo */

%type <dval> exp   /* Tipo asociado a las expresiones: double */

%left '-' '+'      /* Precedencia de operadores aditiva */
%left '*' '/'      /* Precedencia de operadores multiplicativa */
%left NEG          /* Operador unario para negación */
%right '^'         /* Operador de potenciación con asociatividad derecha */
      
%%

/* Definición de la gramática */

input:   /* Cadena vacía */
       | input line    /* Varias líneas de entrada */
       ;
      
line:    NL      { 
                  if (interactive) System.out.print("Expresión: "); 
                } /* Línea vacía */
       | exp NL  { 
                  System.out.println(" = " + $1); /* Imprime el resultado */
                  if (interactive) System.out.print("Expresión: "); 
                } /* Expresión seguida de nueva línea */
       ;
      
exp:     NUM                { $$ = $1; }                   /* Número */
       | exp '+' exp        { $$ = $1 + $3; }              /* Suma */
       | exp '-' exp        { $$ = $1 - $3; }              /* Resta */
       | exp '*' exp        { $$ = $1 * $3; }              /* Multiplicación */
       | exp '/' exp        { $$ = $1 / $3; }              /* División */
       | '-' exp  %prec NEG { $$ = -$2; }                  /* Negación unaria */
       | exp '^' exp        { $$ = Math.pow($1, $3); }     /* Potenciación */
       | '(' exp ')'        { $$ = $2; }                   /* Expresión entre paréntesis */
       ;

%%

/* Implementación del analizador */

private Yylex lexer; /* Analizador léxico generado por JFlex */

/* Método para invocar al analizador léxico */
private int yylex () {
  int yyl_return = -1;
  try {
    yylval = new ParserVal(0); /* Inicializa el valor semántico */
    yyl_return = lexer.yylex(); /* Llama al analizador léxico */
  }
  catch (IOException e) {
    System.err.println("IO error :" + e);
  }
  return yyl_return;
}

/* Método para manejar errores de sintaxis */
public void yyerror (String error) {
  System.err.println("Error: " + error);
}

/* Constructor del parser: inicializa el analizador léxico */
public Parser(Reader r) {
  lexer = new Yylex(r, this);
}

static boolean interactive; /* Modo interactivo */

/* Método principal */
public static void main(String args[]) throws IOException {
  System.out.println("BYACC/Java with JFlex Calculator Demo");

  Parser yyparser;
  if (args.length > 0) {
    /* Modo archivo: parsea un archivo dado como argumento */
    yyparser = new Parser(new FileReader(args[0]));
  } else {
    /* Modo interactivo */
    System.out.println("[Quit with CTRL-D]");
    System.out.print("Expresión: ");
    interactive = true;
    yyparser = new Parser(new InputStreamReader(System.in));
  }

  yyparser.yyparse(); /* Ejecuta el análisis sintáctico */
  
  if (interactive) {
    System.out.println();
    System.out.println("Que tenga un lindo día :D");
  }
}
