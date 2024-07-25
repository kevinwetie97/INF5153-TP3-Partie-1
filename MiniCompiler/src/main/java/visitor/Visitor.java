package visitor;

import ast.*;

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
