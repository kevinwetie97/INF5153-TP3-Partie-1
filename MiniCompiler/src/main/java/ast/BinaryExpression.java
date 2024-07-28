package main.java.ast;

import main.java.visitor.Visitor;

public class BinaryExpression extends Expression {
    private Expression leftExpression;
    private char operator;
    private Expression rightExpression;

    public BinaryExpression(Expression leftExpression, char operator, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public char getOperator() {
        return operator;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
