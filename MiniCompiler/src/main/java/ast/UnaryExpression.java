package ast;

import visitor.Visitor;

public class UnaryExpression extends Expression {
    private char operator;
    private Expression expression;

    public UnaryExpression(char operator, Expression expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public char getOperator() {
        return operator;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
