package main.java.ast;
import visitor.Visitor;

public class StatementPrint extends Statement {
    private Expression expression;

    public StatementPrint(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
