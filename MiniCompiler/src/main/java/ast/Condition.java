package ast;

import visitor.Visitor;

public class Condition {
    private Expression leftExpression;
    private Expression rightExpression;
    private String operator;

    public Condition(Expression leftExpression, String operator, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }

    public Expression getLeftExpression() {
        return leftExpression;
    }

    public Expression getRightExpression() {
        return rightExpression;
    }

    public String getOperator() {
        return operator;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
