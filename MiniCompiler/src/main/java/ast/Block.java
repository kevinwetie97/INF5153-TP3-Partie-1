package main.java.ast;

import main.java.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un bloc d'instructions dans l'AST.
 * Un bloc est composé d'une liste d'instructions.
 */
public class Block extends Statement {
    private List<Statement> statements;

    /**
     * Constructeur de la classe Block.
     * Initialise un bloc vide.
     */
    public Block() {
        this.statements = new ArrayList<>();
    }

    /**
     * Ajoute une instruction au bloc.
     *
     * @param statement l'instruction à ajouter
     */
    public void addStatement(Statement statement) {
        statements.add(statement);
    }

    /**
     * Retourne la liste des instructions du bloc.
     *
     * @return la liste des instructions
     */
    public List<Statement> getStatements() {
        return statements;
    }

    /**
     * Accepte un visiteur pour effectuer une opération sur ce bloc.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
