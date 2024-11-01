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

public interface Type {
    String getName();        
    short getItems();
    short getTam();    
    int getParenId();
    SymbolTable getParentStruct();
}