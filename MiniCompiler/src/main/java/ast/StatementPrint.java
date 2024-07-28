package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Représente une instruction de type print dans l'AST.
 * Une instruction print affiche la valeur d'une expression.
 */
public class StatementPrint extends Statement {
    private Expression expression;

    /**
     * Constructeur de la classe StatementPrint.
     *
     * @param expression l'expression dont la valeur doit être affichée
     */
    public StatementPrint(Expression expression) {
        this.expression = expression;
    }

    /**
     * Retourne l'expression dont la valeur doit être affichée.
     *
     * @return l'expression à afficher
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * Accepte un visiteur pour effectuer une opération sur cette instruction print.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
