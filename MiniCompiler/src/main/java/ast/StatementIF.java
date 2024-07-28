package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Représente une instruction conditionnelle if dans l'AST.
 * Une instruction if exécute un bloc d'instructions si une condition est vraie,
 * et un autre bloc d'instructions optionnel si la condition est fausse.
 */
public class StatementIF extends Statement {
    private Condition condition;
    private Block thenBlock;
    private Block elseBlock;

    /**
     * Constructeur de la classe StatementIF.
     *
     * @param condition la condition à évaluer
     * @param thenBlock le bloc d'instructions à exécuter si la condition est vraie
     * @param elseBlock le bloc d'instructions à exécuter si la condition est fausse (peut être null)
     */
    public StatementIF(Condition condition, Block thenBlock, Block elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    /**
     * Retourne la condition de l'instruction if.
     *
     * @return la condition
     */
    public Condition getCondition() {
        return condition;
    }

    /**
     * Retourne le bloc d'instructions à exécuter si la condition est vraie.
     *
     * @return le bloc then
     */
    public Block getThenBlock() {
        return thenBlock;
    }

    /**
     * Retourne le bloc d'instructions à exécuter si la condition est fausse.
     *
     * @return le bloc else, peut être null
     */
    public Block getElseBlock() {
        return elseBlock;
    }

    /**
     * Accepte un visiteur pour effectuer une opération sur cette instruction if.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
