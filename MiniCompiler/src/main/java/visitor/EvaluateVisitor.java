package main.java.visitor;

import main.java.ast.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EvaluateVisitor implements Visitor {
    private Map<String, Integer> variableValues = new HashMap<>();

    @Override
    public void visit(UnitCompilation unitCompilation) {
        unitCompilation.getBlock().accept(this);
    }

    @Override
    public void visit(Block block) {
        for (Statement statement : block.getStatements()) {
            statement.accept(this);
        }
    }

    @Override
    public void visit(Assignment assignment) {
        String varName = assignment.getIdentifier().getName();
        int value = evaluateExpression(assignment.getExpression());
        variableValues.put(varName, value);
    }

    @Override
    public void visit(StatementIF statementIF) {
        int conditionValue = evaluateExpression(statementIF.getCondition());
        if (conditionValue != 0) {
            statementIF.getThenBlock().accept(this);
        } else if (statementIF.getElseBlock() != null) {
            statementIF.getElseBlock().accept(this);
        }
    }

    @Override
    public void visit(StatementWhile statementWhile) {
        while (evaluateExpression(statementWhile.getCondition()) != 0) {
            statementWhile.getBlock().accept(this);
        }
    }

    @Override
    public void visit(StatementPrint statementPrint) {
        int value = evaluateExpression(statementPrint.getExpression());
        System.out.println(value);
    }

    @Override
    public void visit(StatementRead statementRead) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(statementRead.getLiteralString().getValue() + " ");
        int value = scanner.nextInt();
        variableValues.put(statementRead.getIdentifier().getName(), value);
    }

    @Override
    public void visit(LiteralNumber literalNumber) {
        // Rien à faire ici
    }

    @Override
    public void visit(LiteralString literalString) {
        // Rien à faire ici
    }

    @Override
    public void visit(Identifier identifier) {
        // Rien à faire ici
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        // Rien à faire ici
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        // Rien à faire ici
    }

    @Override
    public void visit(Condition condition) {
        // Rien à faire ici
    }

    private int evaluateExpression(Expression expression) {
        if (expression instanceof LiteralNumber) {
            return ((LiteralNumber) expression).getValue();
        } else if (expression instanceof Identifier) {
            String varName = ((Identifier) expression).getName();
            return variableValues.getOrDefault(varName, 0);
        } else if (expression instanceof BinaryExpression) {
            BinaryExpression binaryExpr = (BinaryExpression) expression;
            int leftValue = evaluateExpression(binaryExpr.getLeftExpression());
            int rightValue = evaluateExpression(binaryExpr.getRightExpression());
            switch (binaryExpr.getOperator()) {
                case '+': return leftValue + rightValue;
                case '-': return leftValue - rightValue;
                case '*': return leftValue * rightValue;
                case '/': return leftValue / rightValue;
            }
        }
        return 0;
    }
}
