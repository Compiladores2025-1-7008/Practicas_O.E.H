/**
 * Escáner que detecta el lenguaje C_1
*/

package main.jflex;

import main.java.ClaseLexica;
import main.java.Token;

%%

%{
    public Token actual;
%}

%public
%class Lexer
%standalone
%unicode

espacio=[ \t\n\r]+

%%

{espacio} {/* Ignorar espacios en blanco */}

/* Palabras clave */
"int"                { return new Token(ClaseLexica.INT, yytext()); }
"float"              { return new Token(ClaseLexica.FLOAT, yytext()); }
"if"                 { return new Token(ClaseLexica.IF, yytext()); }
"else"               { return new Token(ClaseLexica.ELSE, yytext()); }
"while"              { return new Token(ClaseLexica.WHILE, yytext()); }

/* Números */
[0-9]+               { return new Token(ClaseLexica.NUMERO, yytext()); }
[0-9]+\.[0-9]+(e[+-]?[0-9]+)? { return new Token(ClaseLexica.NUMERO, yytext()); }

/* Identificadores */
[a-zA-Z_][a-zA-Z0-9_]* { return new Token(ClaseLexica.ID, yytext()); }

/* Símbolos */
";"                  { return new Token(ClaseLexica.PYC, yytext()); }
","                  { return new Token(ClaseLexica.COMA, yytext()); }
"("                  { return new Token(ClaseLexica.LPAR, yytext()); }
")"                  { return new Token(ClaseLexica.RPAR, yytext()); }

/* Errores */
.                    { System.out.println("Error: Caracter no reconocido: " + yytext()); }

%%
