package main.java.ast;
import visitor.Visitor;

public class StatementIF extends Statement {
    private Condition condition;
    private Block blockThen;
    private Block blockElse;

    public StatementIF(Condition condition, Block blockThen, Block blockElse) {
        this.condition = condition;
        this.blockThen = blockThen;
        this.blockElse = blockElse;
    }

    public Condition getCondition() {
        return condition;
    }

    public Block getBlockThen() {
        return blockThen;
    }

    public Block getBlockElse() {
        return blockElse;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
