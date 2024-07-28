package main.java.ast;
import visitor.Visitor;

public class UnitCompilation {
    private Block block;

    public UnitCompilation(Block block) {
        this.block = block;
    }

    public Block getBlock() {
        return block;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
