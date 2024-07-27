package main.java.ast;

import main.java.visitor.Visitor;

public abstract class Expression {
    public abstract void accept(Visitor visitor);
}
