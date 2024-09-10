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

espacio = [ \t\n\r]+

%%

{espacio} { /* Ignorar espacios */ }

"int"       { System.out.println(new Token(ClaseLexica.INT, "int")); }
"float"     { System.out.println(new Token(ClaseLexica.FLOAT, "float")); }
"if"        { System.out.println(new Token(ClaseLexica.IF, "if")); }
"else"      { System.out.println(new Token(ClaseLexica.ELSE, "else")); }
"while"     { System.out.println(new Token(ClaseLexica.WHILE, "while")); }

[0-9]+      { System.out.println(new Token(ClaseLexica.NUMERO, yytext())); }
[0-9]+"."[0-9]+([eE][+-]?[0-9]+)? { System.out.println(new Token(ClaseLexica.NUMERO, yytext())); }

[a-zA-Z_][a-zA-Z0-9_]* { System.out.println(new Token(ClaseLexica.ID, yytext())); }

";"         { System.out.println(new Token(ClaseLexica.PYC, ";")); }
","         { System.out.println(new Token(ClaseLexica.COMA, ",")); }
"("         { System.out.println(new Token(ClaseLexica.LPAR, "(")); }
")"         { System.out.println(new Token(ClaseLexica.RPAR, ")")); }

.           { /* Ignorar cualquier otro carácter */ }
