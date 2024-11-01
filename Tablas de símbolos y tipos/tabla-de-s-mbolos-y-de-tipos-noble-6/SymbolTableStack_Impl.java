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

import java.util.ArrayList;
import java.util.Optional;

// Clase que implementa la pila de tablas de símbolos
public class SymbolTableStack_Impl implements SymbolTableStack {
    private ArrayList<SymbolTable> stack = new ArrayList<>();

    // Método push para agregar una tabla a la pila
    @Override
    public void push(SymbolTable table) {
        stack.add(table);
    }

    // Método pop para quitar la tabla superior de la pila
    @Override
    public SymbolTable pop() {
        if (stack.isEmpty()) {

            // Se maneja la excepción en caso de que la pila sea vacía
            throw new IllegalStateException("No hay tablas en la pila.");

        }

        // Quita y regresa la tabla superior
        return stack.remove(stack.size() - 1);

    }

    // Método peek para obtener la tabla superior sin quitarla
    @Override
    public Optional<SymbolTable> peek() {
        if (stack.isEmpty()) {

            // Regresa empty si la pila es vacía
            return Optional.empty();

        }

        // Regresa la tabla superior
        return Optional.of(stack.get(stack.size() - 1));

    }

    // Método base para obtener la tabla base
    @Override
    public Optional<SymbolTable> base() {
        if (stack.isEmpty()) {

            // Regresa empty si la pila es vacía
            return Optional.empty();

        }

        // Regresa la tabla base, es decir, el primer elemento
        return Optional.of(stack.get(0));

    }

    // Método lookup para buscar un símbolo en la pila
    @Override
    public Optional<Symbol> lookup(String id) {
        for (int i = stack.size() - 1; i >= 0; i--) {

            // Busca el símbolo en la cima de la pila
            Symbol symbol = stack.get(i).lookup(id);

            if (symbol != null) {

                return Optional.of(symbol);
            
            }
        }

        // Regresa empty si el símbolo no fue encontrado
        return Optional.empty();

    }
}