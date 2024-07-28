package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Représente une instruction d'affectation dans l'AST.
 * Une instruction d'affectation attribue une valeur à une variable.
 */
public class Assignment extends Statement {
    private Identifier identifier;
    private Expression expression;

    /**
     * Constructeur de la classe Assignment.
     *
     * @param identifier l'identifiant de la variable à laquelle la valeur est assignée
     * @param expression l'expression dont la valeur est assignée à la variable
     */
    public Assignment(Identifier identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    /**
     * Retourne l'identifiant de la variable à laquelle la valeur est assignée.
     *
     * @return l'identifiant de la variable
     */
    public Identifier getIdentifier() {
        return identifier;
    }

    /**
     * Retourne l'expression dont la valeur est assignée à la variable.
     *
     * @return l'expression assignée à la variable
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Accepte un visiteur pour effectuer une opération sur cette instruction d'affectation.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
