package main.java.ast;

import main.java.visitor.Visitor;

public class Condition extends Expression {
    private Expression leftExpression;
    private String operator;
    private Expression rightExpression;

    public Condition(Expression leftExpression, String operator, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public String getOperator() {
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
