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

// Clase para implementar la interfaz Type
public class Type_Impl implements Type {

    // Nombre del tipo
    private String name;

    // Número de elementos
    private short items;

    // Tamaño del tipo
    private short tam;

    // Identificador del padre
    private int parenId;

    // Estructura padre
    private SymbolTable parentStruct;

    // Constructor
    public Type_Impl(String name, short items, short tam, int parenId, SymbolTable parentStruct) {
        this.name = name;
        this.items = items;
        this.tam = tam;
        this.parenId = parenId;
        this.parentStruct = parentStruct;
    }

    // Métodos de la interfaz Type

    // Método getName que regresa el nombre del tipo
    @Override
    public String getName() {
        return name;
    }

    // Método getItems que regresa el número de elementos del tipo
    @Override
    public short getItems() {
        return items;
    }

    // Método getTam que regresa el tamaño del tipo
    @Override
    public short getTam() {
        return tam;
    }

    // Método getParenID que regresa el identificador del padre
    @Override
    public int getParenId() {
        return parenId;
    }

    // Método getParentStruct que regresa la estructura del padre
    @Override
    public SymbolTable getParentStruct() {
        return parentStruct;
    }
}