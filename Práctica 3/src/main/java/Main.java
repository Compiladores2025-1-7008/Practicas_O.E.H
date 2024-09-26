package main.java;

import java.io.FileNotFoundException;
import java.io.FileReader;
import main.jflex.Lexer;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Error: Debes proporcionar el archivo de entrada.");
            System.exit(1);
        }

        try {
            Parser parser = new Parser(new Lexer(new FileReader(args[0])));
            parser.parse();
        } catch (FileNotFoundException fnfe) {
            System.err.println("Error: No fue posible leer del archivo de entrada: " + args[0]);
            System.exit(1);
        }
    }
}
