package main.java.ast;

import main.java.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Block extends Statement {
    private List<Statement> statements;

    public Block() {
        this.statements = new ArrayList<>();
    }

    public void addStatement(Statement statement) {
        statements.add(statement);
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
