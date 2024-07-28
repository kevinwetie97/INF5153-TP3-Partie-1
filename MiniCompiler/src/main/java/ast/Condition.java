package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Représente une condition dans l'AST.
 * Une condition est composée de deux expressions opérandes et d'un opérateur conditionnel.
 */
public class Condition extends Expression {
    private Expression leftExpression;
    private String operator;
    private Expression rightExpression;

    /**
     * Constructeur de la classe Condition.
     *
     * @param leftExpression l'expression opérande gauche
     * @param operator l'opérateur conditionnel
     * @param rightExpression l'expression opérande droite
     */
    public Condition(Expression leftExpression, String operator, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }

    /**
     * Retourne l'expression opérande gauche.
     *
     * @return l'expression opérande gauche
     */
    public Expression getLeftExpression() {
        return leftExpression;
    }

    /**
     * Retourne l'opérateur conditionnel.
     *
     * @return l'opérateur conditionnel
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Retourne l'expression opérande droite.
     *
     * @return l'expression opérande droite
     */
    public Expression getRightExpression() {
        return rightExpression;
    }

    /**
     * Accepte un visiteur pour effectuer une opération sur cette condition.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
