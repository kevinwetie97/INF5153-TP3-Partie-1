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
        // Les numériques ne nécessitent aucune action spécifique.
    }

    @Override
    public void visit(LiteralString literalString) {
        // Les chaîne de caractères ne nécessitent aucune action spécifique.
    }

    @Override
    public void visit(Identifier identifier) {
        // Les identifiants ne nécessitent aucune action spécifique ici.
    }

    @Override
    public void visit(UnaryExpression unaryExpression) {
        // L'évaluation des expressions unaires pourrait être implémentée ici si nécessaire.
    }

    @Override
    public void visit(BinaryExpression binaryExpression) {
        // L'évaluation des expressions binaires est effectuée ailleurs.
    }

    @Override
    public void visit(Condition condition) {
        // L'évaluation des conditions est effectuée ailleurs.
    }

    private int evaluateExpression(Expression expression) {
        if (expression instanceof LiteralNumber) {
            return ((LiteralNumber) expression).getValue();
        } else if (expression instanceof Identifier) {
            String varName = ((Identifier) expression).getName();
            return variableValues.getOrDefault(varName, 0);
        } else if (expression instanceof UnaryExpression) {
            UnaryExpression unaryExpr = (UnaryExpression) expression;
            int value = evaluateExpression(unaryExpr.getExpression());
            switch (unaryExpr.getOperator()) {
                case '+': return +value;
                case '-': return -value;
            }
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
        } else if (expression instanceof Condition) {
            Condition condition = (Condition) expression;
            int leftValue = evaluateExpression(condition.getLeftExpression());
            int rightValue = evaluateExpression(condition.getRightExpression());
            switch (condition.getOperator()) {
                case "==": return leftValue == rightValue ? 1 : 0;
                case "!=": return leftValue != rightValue ? 1 : 0;
            }
        }
        return 0;
    }
}
