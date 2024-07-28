package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Représente un littéral de chaîne de caractères dans l'AST.
 * Un littéral de chaîne est une séquence de caractères entourée de guillemets.
 */
public class LiteralString extends Expression {
    private String value;

    /**
     * Constructeur de la classe LiteralString.
     *
     * @param value la valeur du littéral de chaîne
     */
    public LiteralString(String value) {
        this.value = value;
    }

    /**
     * Retourne la valeur du littéral de chaîne.
     *
     * @return la valeur de la chaîne de caractères
     */
    public String getValue() {
        return value;
    }

    /**
     * Accepte un visiteur pour effectuer une opération sur ce littéral de chaîne.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
