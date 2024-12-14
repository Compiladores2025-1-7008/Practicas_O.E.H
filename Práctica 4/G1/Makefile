# Universidad Nacional Autónoma de México
# Facultad de Ciencias
# Compiladores 2025-1
# Osorio Escandón Huriel
# Huriel117@ciencias.unam.mx
# 317204652

# Definimos las variables para los comandos de BYACCJ y JFLEX
BYACCJ = byaccj -J   # Comando para ejecutar BYACCJ con la opción -J
JFLEX  = jflex       # Comando para ejecutar JFLEX

# Objetivo principal 'test', que depende de 'all' para compilar todo
test: all
	# Ejecuta el programa Java, pasando el archivo 'test.txt' como entrada
	java -cp out Parser test.txt

# Objetivo 'all', que depende de 'build' para compilar los archivos necesarios
all: build

# Objetivo 'build', que depende de 'Parser.class' para compilar la clase Parser
build: Parser.class

# Objetivo 'clean', para limpiar los archivos generados y directorios de salida
clean:
	# Elimina el directorio 'out' y todo su contenido
	rm -rf out

# Regla para generar 'Parser.class', que depende de 'Yylex.java' y 'Parser.java'
Parser.class: Yylex.java Parser.java
	# Compila todos los archivos '.java' en el directorio 'out'
	javac -d out out/*.java

# Regla para generar 'Yylex.java' a partir del archivo 'Lexer.flex'
Yylex.java: src/main/jflex/Lexer.flex
	# Ejecuta JFLEX para generar el lexer y lo coloca en el directorio 'out'
	$(JFLEX) -d out $<

# Regla para generar 'Parser.java' a partir del archivo 'Parser.y' con BYACCJ
Parser.java: src/main/byacc/Parser.y
	# Ejecuta BYACCJ para generar 'Parser.java' y 'ParserVal.java'
	$(BYACCJ) $< ;  mv Parser.java ParserVal.java out
