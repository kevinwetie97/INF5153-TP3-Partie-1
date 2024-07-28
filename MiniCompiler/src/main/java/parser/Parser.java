package main.java.parser;

import main.java.ast.*;
import java.util.List;
import java.util.Iterator;

/**
 * Classe Parser responsable de l'analyse des tokens et de la construction de l'AST.
 */

public class Parser {
    private Iterator<String> tokens;
    private String currentToken;

    /**
     * Analyse le code source et construit l'AST.
     *
     * @param sourceCode le code source sous forme de chaîne de caractères
     * @return la racine de l'AST
     */
    public UnitCompilation parse(String sourceCode) {
        List<String> tokenList = Lexer.tokenize(sourceCode);
        tokens = tokenList.iterator();
        advance();

        Block mainBlock = parseBlock();
        return new UnitCompilation(mainBlock);
    }

    /**
     * Avance au token suivant dans la liste.
     */
    private void advance() {
        if (tokens.hasNext()) {
            currentToken = tokens.next();
        } else {
            currentToken = null;
        }
    }

    /**
     * Analyse un bloc d'instructions entre accolades.
     *
     * @return le bloc analysé
     */
    private Block parseBlock() {
        Block block = new Block();
        if ("{".equals(currentToken)) {
            advance();
            while (!"}".equals(currentToken)) {
                block.addStatement(parseStatement());
            }
            advance();
        }
        return block;
    }

    /**
     * Analyse une instruction.
     *
     * @return l'instruction analysée
     */
    private Statement parseStatement() {
        if (currentToken.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            return parseAssignment();
        } else if ("if".equals(currentToken)) {
            return parseStatementIF();
        } else if ("while".equals(currentToken)) {
            return parseStatementWhile();
        } else if ("print".equals(currentToken)) {
            return parseStatementPrint();
        } else if ("read".equals(currentToken)) {
            return parseStatementRead();
        } else {
            throw new IllegalArgumentException("Token inattendu: " + currentToken);
        }
    }

    /**
     * Analyse une instruction d'affectation.
     *
     * @return l'affectation analysée
     */
    private Assignment parseAssignment() {
        Identifier identifier = new Identifier(currentToken);
        advance();
        advance(); // Ignore '='
        Expression expression = parseExpression();
        advance(); // Ignore ';'
        return new Assignment(identifier, expression);
    }

    /**
     * Analyse une instruction conditionnelle if.
     *
     * @return l'instruction if analysée
     */
    private StatementIF parseStatementIF() {
        advance(); // Ignore 'if'
        advance(); // Ignore '('
        Condition condition = parseCondition();
        advance(); // Ignore ')'
        advance(); // Ignore 'then'
        Block thenBlock = parseBlock();
        Block elseBlock = null;
        if ("else".equals(currentToken)) {
            advance();
            elseBlock = parseBlock();
        }
        return new StatementIF(condition, thenBlock, elseBlock);
    }

    /**
     * Analyse une instruction while.
     *
     * @return l'instruction while analysée
     */
    private StatementWhile parseStatementWhile() {
        advance(); // Ignore 'while'
        advance(); // Ignore '('
        Condition condition = parseCondition();
        advance(); // Ignore ')'
        Block block = parseBlock();
        return new StatementWhile(condition, block);
    }

    /**
     * Analyse une instruction print.
     *
     * @return l'instruction print analysée
     */
    private StatementPrint parseStatementPrint() {
        advance(); // Ignore 'print'
        advance(); // Ignore '('
        Expression expression = parseExpression();
        advance(); // Ignore ')'
        advance(); // Ignore ';'
        return new StatementPrint(expression);
    }

    /**
     * Analyse une instruction read.
     *
     * @return l'instruction read analysée
     */
    private StatementRead parseStatementRead() {
        advance(); // Ignore 'read'
        advance(); // Ignore '('
        LiteralString literalString = new LiteralString(currentToken);
        advance();
        advance(); // Ignore ','
        Identifier identifier = new Identifier(currentToken);
        advance();
        advance(); // Ignore ')'
        advance(); // Ignore ';'
        return new StatementRead(literalString, identifier);
    }

    /**
     * Analyse une condition.
     *
     * @return la condition analysée
     */
    private Condition parseCondition() {
        Expression leftExpression = parseExpression();
        String operator = currentToken;
        advance();
        Expression rightExpression = parseExpression();
        return new Condition(leftExpression, operator, rightExpression);
    }

    /**
     * Analyse une expression.
     *
     * @return l'expression analysée
     */
    private Expression parseExpression() {
        if (currentToken.matches("\\d+")) {
            LiteralNumber literalNumber = new LiteralNumber(Integer.parseInt(currentToken));
            advance();
            return literalNumber;
        } else if (currentToken.startsWith("\"")) {
            LiteralString literalString = new LiteralString(currentToken);
            advance();
            return literalString;
        } else if (currentToken.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            Identifier identifier = new Identifier(currentToken);
            advance();
            return identifier;
        } else if ("+".equals(currentToken) || "-".equals(currentToken)) {
            char operator = currentToken.charAt(0);
            advance();
            Expression expression = parseExpression();
            return new UnaryExpression(operator, expression);
        } else {
            Expression leftExpression = parseExpression();
            char operator = currentToken.charAt(0);
            advance();
            Expression rightExpression = parseExpression();
            return new BinaryExpression(leftExpression, operator, rightExpression);
        }
    }
}