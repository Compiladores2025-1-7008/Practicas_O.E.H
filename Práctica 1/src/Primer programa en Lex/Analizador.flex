%{
  //
%}

%%

[ \t\n\r]+            { System.out.print("Encontré un espacio en blanco\n"); }

0[xX][0-9a-fA-F]+     { System.out.print("Encontré un hexadecimal: " + yytext() + "\n"); }

(if|else|while|return|int) { System.out.print("Encontré una palabra reservada: " + yytext() + "\n"); }

[a-zA-Z_][a-zA-Z0-9_]{0,31} { System.out.print("Encontré un identificador: " + yytext() + "\n"); }

.                     { System.out.print("Encontré un carácter no manejado: " + yytext() + "\n"); }

%%