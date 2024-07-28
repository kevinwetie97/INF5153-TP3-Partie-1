/**
 * TRAVAIL PRATIQUE 3 FAIT PAR
 * KEVIN JORDAN WETIE TANKEU WETK20029707
 *                  &&
 * OUATTARA GNANANGA PARFAIT OUAG77040300
 */
package main.java.main;

import main.java.ast.*;
import main.java.visitor.EvaluateVisitor;

public class Main {
    public static void main(String[] args) {
        // Création de l'AST pour le code donné
        // {
        //   a = b + 18 ;
        //   if (a != 2 ) then {
        //      c = 15 ;
        //   }
        //   print(c) ;
        // }

        // Expression: b + 18
        Expression expr1 = new BinaryExpression(new Identifier("b"), '+', new LiteralNumber(18));

        // Assignment: a = b + 18;
        Assignment assignment1 = new Assignment(new Identifier("a"), expr1);

        // Condition: a != 2
        Condition condition = new Condition(new Identifier("a"), "!=", new LiteralNumber(2));

        // Then block: { c = 15; }
        Block thenBlock = new Block();
        Assignment assignment2 = new Assignment(new Identifier("c"), new LiteralNumber(15));
        thenBlock.addStatement(assignment2);

        // If statement: if (a != 2) then { c = 15; }
        StatementIF statementIF = new StatementIF(condition, thenBlock, null);

        // Print statement: print(c);
        StatementPrint printStatement = new StatementPrint(new Identifier("c"));

        // Main block
        Block mainBlock = new Block();
        mainBlock.addStatement(assignment1);
        mainBlock.addStatement(statementIF);
        mainBlock.addStatement(printStatement);

        // compilation
        UnitCompilation unitCompilation = new UnitCompilation(mainBlock);

        // Utilisation du visiteur pour évaluer l'AST
        EvaluateVisitor visitor = new EvaluateVisitor();
        unitCompilation.accept(visitor);
    }
}
