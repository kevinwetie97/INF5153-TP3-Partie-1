package main.java.ast;

import main.java.visitor.Visitor;

public abstract class Statement {
    public abstract void accept(Visitor visitor);
}
