package main.java.ast;

import main.java.visitor.Visitor;

public class UnitCompilation extends Statement {
    private Block block;

    public UnitCompilation(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
