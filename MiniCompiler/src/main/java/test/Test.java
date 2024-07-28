package main.java.test;
import main.java.ast.UnitCompilation;
import main.java.parser.Parser;
import main.java.visitor.EvaluateVisitor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
public class Test {
    public static void main(String[] args) {
        String testFile = "main/java/test/test1.txt";

        try {
            // Lire le contenu du fichier
            String sourceCode = new String(Files.readAllBytes(Paths.get(testFile)));

            // Créer le parseur et analyser le contenu
            Parser parser = new Parser();
            UnitCompilation unitCompilation = parser.parse(sourceCode);

            // Utiliser le visiteur pour évaluer l'AST
            EvaluateVisitor visitor = new EvaluateVisitor();
            unitCompilation.accept(visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}