/*
  Universidad Nacional Autónoma de México
  Facultad de Ciencias
  Compiladores 2025-1
  Osorio Escandón Huriel
  Huriel117@ciencias.unam.mx 
  317204652
 */

%%

%byaccj /* Indica que el lexer se generará para BYACC/J */

%{
  /* Declaración de una referencia al parser */
  private Parser yyparser;

  /* Constructor de la clase Yylex, que inicializa el lexer con un Reader
     y establece una referencia al parser (Parser) */
  public Yylex(java.io.Reader r, Parser yyparser) {
    this(r); /* Llama al constructor base del lexer */
    this.yyparser = yyparser; /* Asocia el parser */
  }
%}

/* Definición de patrones de tokens */
NUM = [0-9]+ ("." [0-9]+)? /* Un número: entero o flotante */
NL  = \n | \r | \r\n       /* Nueva línea: compatible con varios sistemas */

%%

/* Definiciones del lexer */

/* Operadores matemáticos y paréntesis: retornan directamente el valor del carácter ASCII */
"+" | 
"-" | 
"*" | 
"/" | 
"^" | 
"(" | 
")"    { 
          return (int) yycharat(0); /* Retorna el carácter encontrado como token */
        }

/* Nueva línea: retorna el token `NL` definido en el parser */
{NL}   { 
          return Parser.NL; 
        }

/* Números: convierte el texto del token a un número de tipo `double` y lo asocia a `yylval` */
{NUM}  { 
          yyparser.yylval = new ParserVal(Double.parseDouble(yytext())); /* Asigna el valor numérico */
          return Parser.NUM; /* Retorna el token `NUM` */
        }

/* Espacios en blanco: los ignora */
[ \t]+ { }

/* Retroceso: emite un mensaje de error si se encuentra un backspace */
\b     { 
          System.err.println("Sorry, backspace doesn't work"); /* Mensaje de advertencia */
        }

/* Caracteres inesperados: imprime un error y retorna un valor de error (-1) */
[^]    { 
          System.err.println("Error: unexpected character '" + yytext() + "'"); /* Mensaje de error */
          return -1; /* Token de error */
        }
