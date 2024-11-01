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

import java.util.HashMap;
import java.util.Map;

// Clase SymbolTable para implementar la gestión de símbolos
public class SymbolTable {

    // Mapa de símbolos
    private Map<String, Symbol> symbols = new HashMap<>();

    // Tabla de símbolos padre
    private SymbolTable parent;

    // Constructor para inicializar la tabla de símbolos con un padre
    public SymbolTable(SymbolTable parent) {
        this.parent = parent;
    }

    // Método addSymbol para agregar un símbolo a la tabla
    public void addSymbol(String name, Symbol symbol) {

        // Agrega el símbolo al mapa
        symbols.put(name, symbol);

    }

    // Método lookup para buscar un símbolo por su nombre
    public Symbol lookup(String name) {

        // Busca el símbolo en la tabla actual
        Symbol symbol = symbols.get(name);

        if (symbol != null) {

            // En caso de encontrar el símbolo, lo regresa
            return symbol;

        }

        if (parent != null) {

            // En caso de no encontrarlo, busca el símbolo en la tabla padre
            return parent.lookup(name);

        }

        // Regresa null si el símbolo no fue encontrado
        return null;

    }

    // Método getParent para obtener la tabla padre
    public SymbolTable getParent() {
        return parent;
    }
}