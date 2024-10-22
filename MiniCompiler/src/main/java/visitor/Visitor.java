package main.java.visitor;

import main.java.ast.*;

/**
 * Interface Visitor pour le patron de conception Visiteur.
 * Cette interface définit les méthodes pour visiter chaque type de nœud dans l'AST.
 */
public interface Visitor {
    void visit(UnitCompilation unitCompilation);
    void visit(Block block);
    void visit(Assignment assignment);
    void visit(StatementIF statementIF);
    void visit(StatementWhile statementWhile);
    void visit(StatementPrint statementPrint);
    void visit(StatementRead statementRead);
    void visit(LiteralNumber literalNumber);
    void visit(LiteralString literalString);
    void visit(Identifier identifier);
    void visit(UnaryExpression unaryExpression);
    void visit(BinaryExpression binaryExpression);
    void visit(Condition condition);
}
