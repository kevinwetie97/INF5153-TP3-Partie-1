package main.java.ast;

import main.java.visitor.Visitor;

public class StatementRead extends Statement {
    private LiteralString literalString;
    private Identifier identifier;

    public StatementRead(LiteralString literalString, Identifier identifier) {
        this.literalString = literalString;
        this.identifier = identifier;
    }

    public LiteralString getLiteralString() {
        return literalString;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
