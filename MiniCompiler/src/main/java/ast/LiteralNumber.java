package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Représente un littéral numérique dans l'AST.
 * Un littéral numérique est une valeur entière directe dans le code source.
 */
public class LiteralNumber extends Expression {
    private int value;

    /**
     * Constructeur de la classe LiteralNumber.
     *
     * @param value la valeur entière du littéral numérique
     */
    public LiteralNumber(int value) {
        this.value = value;
    }

    /**
     * Retourne la valeur entière du littéral numérique.
     *
     * @return la valeur entière
     */
    public int getValue() {
        return value;
    }

    /**
     * Accepte un visiteur pour effectuer une opération sur ce littéral numérique.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
