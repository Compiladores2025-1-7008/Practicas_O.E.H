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
 import java.util.Optional;
 
 // Clase para implementar la tabla de tipos
 public class TypeTable_Impl implements TypeTable {
 
     // Mapa de tipos
     private Map<Integer, Type> types = new HashMap<>();
 
     // Contador para asignar identificadores únicos
     private int currentId = 0;
 
     // Método getTam para obtener el tamaño de un tipo por ID
     @Override
     public int getTam(int id) {
         Type type = types.get(id);
 
         // Regresa el tamaño o -1 de no ser encontrado
         return type != null ? type.getTam() : -1;
     }
 
     // Método getItems para obtener el número de elementos de un tipo por ID
     @Override
     public int getItems(int id) {
         Type type = types.get(id);
 
         // Regresa el número de elementos o -1 de no ser encontrado
         return type != null ? type.getItems() : -1;
     }
 
     // Método getName para obtener el nombre de un tipo por ID
     @Override
     public String getName(int id) {
         Type type = types.get(id);
 
         // Regresa el nombre o null de no ser encontrado
         return type != null ? type.getName() : null;
     }
 
     // Método getParenId para obtener el ID del padre de un tipo por ID
     @Override
     public int getParenId(int id) {
         Type type = types.get(id);
 
         // Regresa el identificador del padre o -1 de no ser encontrado
         return type != null ? type.getParenId() : -1;
     }
 
     // Método getParentStruct para obtener la estructura padre de un tipo por ID
     @Override
     public SymbolTable getParentStruct(int id) {
         Type type = types.get(id);
 
         // Regresa la estructura padre o null de no ser encontrado
         return type != null ? type.getParentStruct() : null;
     }
 
     // Método getType para obtener un tipo por ID
     @Override
     public Optional<Type> getType(int id) {
         // Regresa el tipo o empty de no ser encontrado
         return Optional.ofNullable(types.get(id));
     }
 
     // Método addType para agregar un tipo
     @Override
     public int addType(String name, int items, int parent) {
         // Se crea un nuevo tipo
         Type newType = new Type_Impl(name, (short) items, (short) items, parent, null);
 
         // Se agrega el tipo de mapa
         types.put(currentId, newType);
 
         return currentId++;
     }
 
     // Método addType para agregar un tipo con una estructura padre
     @Override
     public int addType(String name, SymbolTable parent) {
         // Se crea un nuevo tipo
         Type newType = new Type_Impl(name, (short) 0, (short) 0, -1, parent);
 
         // Se agrega el tipo de mapa
         types.put(currentId, newType);
 
         return currentId++;
     }
 } 