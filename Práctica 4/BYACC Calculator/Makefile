# Universidad Nacional Autónoma de México
# Facultad de Ciencias
# Compiladores 2025-1
# Osorio Escandón Huriel
# Huriel117@ciencias.unam.mx
# 317204652

# Se definen las herramientas que vamos a utilizar:
BYACCJ = byaccj -J  # BYACC/J para generar el analizador sintáctico
JFLEX  = jflex      # JFlex para generar el analizador léxico

# La regla principal para ejecutar todo el proceso: compilar y ejecutar.
run: all
	java -cp out Parser  # Ejecuta el programa compilado, especificando la carpeta 'out' como classpath

# La regla "all" depende de la regla "build"
all: build  # "all" asegura que la construcción completa esté realizada.

# La regla "build" depende de que exista el archivo 'Parser.class'
build: Parser.class

# Limpia todos los archivos generados
clean:
	rm -rf out  # Elimina la carpeta 'out', donde se guardan los archivos compilados

# Regla para compilar el programa: depende de los archivos generados por JFlex y BYACC/J
Parser.class: Yylex.java Parser.java
	javac -d out out/*.java  # Compila todos los archivos Java en la carpeta 'out'

# Regla para generar el analizador léxico con JFlex:
# Depende de que exista el archivo Lexer.flex
Yylex.java: src/main/jflex/Lexer.flex
	$(JFLEX) -d out $<  # Ejecuta JFlex, genera 'Yylex.java' en la carpeta 'out'

# Regla para generar el analizador sintáctico con BYACC/J:
# Depende de que exista el archivo Parser.y
Parser.java: src/main/byacc/Parser.y
	$(BYACCJ) $<  # Ejecuta BYACC/J con el archivo .y
	mv Parser.java ParserVal.java out  # Mueve los archivos generados a la carpeta 'out'
