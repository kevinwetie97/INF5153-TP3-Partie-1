package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Représente une expression binaire dans l'AST.
 * Une expression binaire est composée de deux expressions opérandes et d'un opérateur binaire.
 */
public class BinaryExpression extends Expression {
    private Expression leftExpression;
    private char operator;
    private Expression rightExpression;

    /**
     * Constructeur de la classe BinaryExpression.
     *
     * @param leftExpression l'expression opérande gauche
     * @param operator l'opérateur binaire
     * @param rightExpression l'expression opérande droite
     */
    public BinaryExpression(Expression leftExpression, char operator, Expression rightExpression) {
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
     * Retourne l'opérateur binaire.
     *
     * @return l'opérateur binaire
     */
    public char getOperator() {
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
     * Accepte un visiteur pour effectuer une opération sur cette expression binaire.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
