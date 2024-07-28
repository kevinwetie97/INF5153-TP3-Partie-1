package main.java.ast;
import visitor.Visitor;

public class LiteralString extends Expression {
    private String value;

    public LiteralString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
