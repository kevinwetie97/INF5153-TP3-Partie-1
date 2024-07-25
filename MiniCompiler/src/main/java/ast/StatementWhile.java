package ast;

import visitor.Visitor;

public class StatementWhile extends Statement {
    private Condition condition;
    private Block block;

    public StatementWhile(Condition condition, Block block) {
        this.condition = condition;
        this.block = block;
    }

    public Condition getCondition() {
        return condition;
    }

    public Block getBlock() {
        return block;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
