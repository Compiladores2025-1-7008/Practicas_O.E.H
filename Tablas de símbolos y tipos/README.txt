/*
 * Universidad Nacional Autónoma de México
 * Facultad de Ciencias
 * Compiladores 2025-1
 * Tablas de símbolos y tipos
 * 
 * Alumno: Osorio Escandón Huriel
 * Correo: Huriel117@ciencias.unam.mx
 * Número de cuenta: 317204652
 */

En esta tarea se implementa una pila de tablas de símbolos y una tabla de tipos implementando
las interfaces sugeridas.

La carpeta tabla-de-s-mbolos-y-de-tipos-noble-6-main contiene:

	1). Symbol.java:
		Define la interfaz Symbol, que especifica métodos para obtener la dirección, tipo,
		categoría y argumentos de un símbolo. 

	2). Symbol_Impl.java:
		Implementa la interfaz Symbol, proporcionando el código para manejar la dirección, 
		tipo, categoría y argumentos de un símbolo, esta clase permite crear instancias de
		símbolos con atributos específicos.

	3). SymbolTable.java:
		Define la clase SymbolTable, que gestiona un conjunto de símbolos utilizando un mapa. 
		Permite agregar nuevos símbolos y buscarlos por nombre, además de proporcionar la 
		funcionalidad de herencia a través de una tabla de símbolos padre.

	4). SymbolTableStack.java:
		Define la interfaz SymbolTableStack, que especifica operaciones para gestionar una 
		pila de tablas de símbolos. Permite apilar (push), desapilar (pop), y acceder a la 
		tabla superior (peek). También incluye métodos para obtener la tabla base y buscar 
		símbolos en la pila.

	5). SymbolTableStack_Impl.java:
		Implementa la interfaz SymbolTableStack, proporcionando la funcionalidad para manejar
		una pila de tablas de símbolos. Permite añadir (push), eliminar (pop) y consultar la 
		tabla superior (peek). También cuenta con un método para acceder a la tabla base y 
		buscar símbolos en la pila.

	6). Type.java:
		Interfaz que define los métodos necesarios para representar un tipo de dato en el 
		sistema de tablas de símbolos. Incluye los métodos para obtener el nombre del tipo,
		el número de elementos, su tamaño, el identificador del tipo padre y la estructura 
		padre asociada.

	7) Type_Impl.java:
		Implementación de la interfaz Type, que representa un tipo de dato en el sistema de
		tablas de símbolos. La clase define atributos como el nombre del tipo, el número de
		elementos, su tamaño, el identificador del tipo padre y la estructura padre. También
		proporciona los métodos para acceder a estos atributos.

	8) TypeParent.java:
		Define la interfaz TypeParent, esta interfaz declara los métodos para obtener el 
		identificador del tipo padre y la estructura padre asociada. Esta proporciona una 
		forma de acceder a la jerarquía de tipos.

	9) TypeTable.java:
		Define la interfaz TypeTable, que especifica los métodos necesarios para gestionar 
		una tabla de tipos. Esta interfaz incluye los métodos para obtener propiedades de 
		tipos como tamaño, número de elementos, nombre, identificador del padre y estructura 
		padre, así como para añadir nuevos tipos a la tabla.

	10) TypeTable_Impl.java:
		Implementa la interfaz TypeTable, proporcionando funcionalidades para gestionar una 
		colección de tipos. Utiliza un mapa para almacenar tipos, asignándoles identificadores
		únicos. Permite obtener información sobre los tipos, como tamaño, número de elementos, 
		nombre y la relación con su estructura padre. También incluye métodos para añadir nuevos
		tipos a la tabla.