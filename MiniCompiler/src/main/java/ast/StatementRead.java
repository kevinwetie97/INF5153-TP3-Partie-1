package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Représente une instruction de type read dans l'AST.
 * Une instruction read lit une valeur entrée par l'utilisateur et l'assigne à une variable.
 */
public class StatementRead extends Statement {
    private LiteralString literalString;
    private Identifier identifier;

    /**
     * Constructeur de la classe StatementRead.
     *
     * @param literalString la chaîne de caractères affichée à l'utilisateur
     * @param identifier l'identifiant de la variable à laquelle la valeur lue est assignée
     */
    public StatementRead(LiteralString literalString, Identifier identifier) {
        this.literalString = literalString;
        this.identifier = identifier;
    }

    /**
     * Retourne la chaîne de caractères affichée à l'utilisateur.
     *
     * @return la chaîne de caractères
     */
    public LiteralString getLiteralString() {
        return literalString;
    }

    /**
     * Retourne l'identifiant de la variable à laquelle la valeur lue est assignée.
     *
     * @return l'identifiant de la variable
     */
    public Identifier getIdentifier() {
        return identifier;
    }

    /**
     * Accepte un visiteur pour effectuer une opération sur cette instruction read.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
