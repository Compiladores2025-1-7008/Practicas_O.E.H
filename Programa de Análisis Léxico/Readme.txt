1) Compilación
Debemos verificar si tenemos instalado el compilador de Java.
Abriremos una terminal, navegaremos hasta dónde se encuentre guardado el archivo AnalizadorLexico.java, después,
vamos a ejecutar el comando:
javac AnalizadorLexico.java

Una vez compilado el archivo, veremos que se generó el archivo llamado AnalizadorLexico.class en el mismo directorio.

2) Ejecución del programa
Después de compilar el programa, podemos ejecutarlo usando el comando java:
java AnalizadorLexico

3) Resultados en la terminal
En el código se uso como ejemplo a "varA = 100 + 25.75 + varB"
Al ejecutar el programa, en la terminal se verá lo siguiente:

Token{tipo=ID, valor='varA'}
Token{tipo=OPERADOR_ASIGNACION, valor='='}
Token{tipo=NUM_ENTERO, valor='100'}
Token{tipo=OPERADOR_SUMA, valor='+'}
Token{tipo=NUM_DECIMAL, valor='25.75'}
Token{tipo=OPERADOR_SUMA, valor='+'}
Token{tipo=ID, valor='varB'}


...Program finished with exit code 0
Press ENTER to exit console.
