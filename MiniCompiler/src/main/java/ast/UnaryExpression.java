package main.java.ast;

import main.java.visitor.Visitor;


/**
 * Représente une expression unaire dans l'AST.
 * Une expression unaire est composée d'un opérateur unaire et d'une expression.
 */
public class UnaryExpression extends Expression {
    private char operator;
    private Expression expression;

    /**
     * Constructeur de la classe UnaryExpression.
     *
     * @param operator l'opérateur unaire
     * @param expression l'expression sur laquelle l'opérateur s'applique
     */
    public UnaryExpression(char operator, Expression expression) {
        this.operator = operator;
        this.expression = expression;
    }

    /**
     * Retourne l'opérateur unaire.
     *
     * @return l'opérateur unaire
     */
    public char getOperator() {
        return operator;
    }

    /**
     * Retourne l'expression sur laquelle l'opérateur s'applique.
     *
     * @return l'expression
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Accepte un visiteur pour effectuer une opération sur cette expression unaire.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
