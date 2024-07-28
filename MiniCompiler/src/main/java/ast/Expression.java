package main.java.ast;
import visitor.Visitor;

public abstract class Expression {
    public abstract void accept(Visitor visitor);
}
