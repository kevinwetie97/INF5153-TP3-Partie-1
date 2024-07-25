package ast;

import visitor.Visitor;

public class LiteralNumber extends Expression {
    private int value;

    public LiteralNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
