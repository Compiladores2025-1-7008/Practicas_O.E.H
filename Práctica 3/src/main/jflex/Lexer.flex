package main.jflex;

import main.java.ClaseLexica;
import main.java.Token;

%%

%{

public Token actual;
public int getLine() { return yyline; }

%}

%public
%class Lexer
%standalone
%unicode
%line

espacio=[ \t\n]

%%

{espacio}+ { }
"int" { System.out.println("Encontramos una palabra reservada"); return ClaseLexica.INT; }
"float" { System.out.println("Encontramos una palabra reservada"); return ClaseLexica.FLOAT; }
"if" { return ClaseLexica.IF; }
"else" { return ClaseLexica.ELSE; }
"while" { return ClaseLexica.WHILE; }
[0-9]+ { return ClaseLexica.NUMERO; }
[a-zA-Z_][a-zA-Z0-9_]* { return ClaseLexica.ID; }
";" { return ClaseLexica.PYC; }
"," { return ClaseLexica.COMA; }
"(" { return ClaseLexica.LPAR; }
")" { return ClaseLexica.RPAR; }
"=" { return ClaseLexica.EQUAL; }
"+" { return ClaseLexica.PLUS; }
"-" { return ClaseLexica.MINUS; }
"*" { return ClaseLexica.TIMES; }
"/" { return ClaseLexica.DIV; }
<<EOF>> { return 0; }
. { return -1; }
