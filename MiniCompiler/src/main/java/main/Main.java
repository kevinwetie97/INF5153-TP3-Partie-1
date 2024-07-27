package main.java.main;

import main.java.ast.*;
import main.java.visitor.EvaluateVisitor;

public class Main {
    public static void main(String[] args) {
        // Création d'un exemple d'AST pour une condition
        Expression left = new Identifier("a");
        Expression right = new LiteralNumber(2);
        Condition condition = new Condition(left, "!=", right);

        // Création d'un bloc then et else
        Block thenBlock = new Block();
        thenBlock.addStatement(new Assignment(new Identifier("b"), new LiteralNumber(1)));

        Block elseBlock = new Block();
        elseBlock.addStatement(new Assignment(new Identifier("b"), new LiteralNumber(0)));

        // Création de StatementIF
        StatementIF statementIF = new StatementIF(condition, thenBlock, elseBlock);

        // Création de UnitCompilation
        Block mainBlock = new Block();
        mainBlock.addStatement(statementIF);

        UnitCompilation unitCompilation = new UnitCompilation(mainBlock);

        // Utilisation du visiteur pour évaluer l'AST
        EvaluateVisitor visitor = new EvaluateVisitor();
        unitCompilation.accept(visitor);
    }
}
