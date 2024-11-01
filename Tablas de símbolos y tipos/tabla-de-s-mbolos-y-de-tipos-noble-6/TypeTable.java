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

import java.util.Optional;

public interface TypeTable {
    //Map<String, Symbol> syms;
    int getTam(int id);        
    int getItems(int id);
    String getName(int id);
    int getParenId(int id);
    SymbolTable getParentStruct(int id);
    Optional<Type> getType(int id);
    
    int addType(String name, int items, int parent);
    int addType(String name, SymbolTable parent);   
}