package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Représente un identifiant dans l'AST.
 * Un identifiant est un nom de variable utilisé dans les expressions et les instructions.
 */
public class Identifier extends Expression {
    private String name;

    /**
     * Constructeur de la classe Identifier.
     *
     * @param name le nom de l'identifiant
     */
    public Identifier(String name) {
        this.name = name;
    }

    /**
     * Retourne le nom de l'identifiant.
     *
     * @return le nom de l'identifiant
     */
    public String getName() {
        return name;
    }

    /**
     * Accepte un visiteur pour effectuer une opération sur cet identifiant.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
