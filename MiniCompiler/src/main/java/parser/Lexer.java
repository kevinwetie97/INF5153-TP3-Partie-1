package main.java.parser;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe responsable de la tokenisation des entrées du code source.
 */

public class Lexer {
    public static List<String> tokenize(String sourceCode) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(sourceCode, " =+*/()-;{}\" \n\t\r", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.startsWith("//")) {
                // Ignorer le reste de la ligne
                while (tokenizer.hasMoreTokens() && !token.equals("\n")) {
                    token = tokenizer.nextToken();
                }
            } else if (!token.trim().isEmpty()) {
                tokens.add(token);
            }
        }

        return tokens;
    }
}
