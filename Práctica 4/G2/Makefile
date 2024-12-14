# Universidad Nacional Autónoma de México
# Facultad de Ciencias
# Compiladores 2025-1
# Osorio Escandón Huriel
# Huriel117@ciencias.unam.mx 
# 317204652

# Definición de las herramientas a utilizar
BYACCJ = byaccj -J  # Comando para ejecutar BYACC/J con la opción -J
JFLEX  = jflex      # Comando para ejecutar JFLEX

# Objetivo principal 'test', que depende de 'all' para compilar todo
test: all
	# Ejecuta el programa Java, pasando el archivo 'test.txt' como entrada
	java -cp out Parser test.txt

# Regla 'all', que depende de 'build' para compilar los archivos necesarios
all: build

# La regla 'build', que depende de 'Parser.class' para compilar el archivo 'Parser.class'
build: Parser.class

# Regla 'clean', para eliminar los archivos generados
clean:
	# Elimina el directorio 'out' y todo su contenido
	rm -rf out

# Regla para generar 'Parser.class' a partir de 'Yylex.java' y 'Parser.java'
Parser.class: Yylex.java Parser.java
	# Compila todos los archivos '.java' en el directorio 'out'
	javac -d out out/*.java

# Regla para generar 'Yylex.java' a partir de 'Lexer.flex' con JFLEX
Yylex.java: src/main/jflex/Lexer.flex
	# Ejecuta JFLEX para generar el lexer y lo coloca en el directorio 'out'
	$(JFLEX) -d out $<

# Regla para generar 'Parser.java' a partir de 'Parser.y' con BYACC/J
Parser.java: src/main/byacc/Parser.y
	# Ejecuta BYACC/J para generar 'Parser.java' y 'ParserVal.java'
	$(BYACCJ) $< ;  mv Parser.java ParserVal.java out
