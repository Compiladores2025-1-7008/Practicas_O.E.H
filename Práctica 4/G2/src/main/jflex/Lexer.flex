/*
  Universidad Nacional Autónoma de México
  Facultad de Ciencias
  Compiladores 2025-1
  Osorio Escandón Huriel
  Huriel117@ciencias.unam.mx 
  317204652
*/

%%

%byaccj  // Indica que este lexer se generará para BYACC/J

%{
  // Declaración de una referencia al parser
  private Parser yyparser;

  // Constructor de la clase Yylex, que inicializa el lexer con un Reader y establece una referencia al parser
  public Yylex(java.io.Reader r, Parser yyparser) {
    this(r);  // Llama al constructor base del lexer para inicializarlo con el Reader
    this.yyparser = yyparser;  // Asocia el parser al lexer
  }
%}

%%

"=" |  // Reconoce el símbolo "="
"." |  // Reconoce el símbolo "."
"+" |  // Reconoce el símbolo "+"
"-" |  // Reconoce el símbolo "-"
"*" |  // Reconoce el símbolo "*"
"/" |  // Reconoce el símbolo "/"
"(" |  // Reconoce el símbolo "("
")"    // Reconoce el símbolo ")"
{ 
  return (int) yycharat(0);  // Retorna el valor del carácter ASCII del símbolo encontrado
}

"var" { 
  return Parser.VAR;  // Si encuentra la palabra "var", retorna el token VAR definido en el parser
}

[a-zA-Z]+ { 
  return Parser.LETRA;  // Si encuentra una secuencia de letras, retorna el token LETRA definido en el parser
}

[0-9]+ { 
  return Parser.DIGITO;  // Si encuentra una secuencia de dígitos, retorna el token DIGITO definido en el parser
}

[ \t\n]+ { 
  // Los espacios en blanco, tabulaciones y saltos de línea son ignorados
}

. { 
  // Si encuentra cualquier carácter no reconocido, muestra un mensaje de error
  System.err.println("carácter no reconocido");
}
