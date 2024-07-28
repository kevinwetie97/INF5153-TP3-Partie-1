package main.java.parser;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe responsable de la tokenisation des entrées du code source.
 */

public class Lexer {

    private static final Pattern TOKEN_PATTERN = Pattern.compile(
            "\\d+|" +              // Numbers
                    "\"[^\"]*\"|" +        // String literals
                    "[a-zA-Z_][a-zA-Z0-9_]*|" +  // Identifiers
                    "==|!=|<=|>=|[{}();,+*/=-]"  // Operators and delimiters
    );

    public static List<String> tokenize(String input) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = TOKEN_PATTERN.matcher(input);
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }

}
