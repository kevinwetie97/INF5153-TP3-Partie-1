package ast;

import visitor.Visitor;

public class Assignment extends Statement {
    private Identifier identifier;
    private Expression expression;

    public Assignment(Identifier identifier, Expression expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
