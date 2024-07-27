package main.java.ast;

import main.java.visitor.Visitor;

public class StatementIF extends Statement {
    private Condition condition;
    private Block thenBlock;
    private Block elseBlock;

    public StatementIF(Condition condition, Block thenBlock, Block elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    public Condition getCondition() {
        return condition;
    }

    public Block getThenBlock() {
        return thenBlock;
    }

    public Block getElseBlock() {
        return elseBlock;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
