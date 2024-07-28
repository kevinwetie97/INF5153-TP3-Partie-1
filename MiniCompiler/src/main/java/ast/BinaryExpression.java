package main.java.ast;
import visitor.Visitor;

public class BinaryExpression extends Expression {
    private Expression leftExpression;
    private Expression rightExpression;
    private char operator;

    public BinaryExpression(Expression leftExpression, char operator, Expression rightExpression) {
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

    public char getOperator() {
        return operator;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
