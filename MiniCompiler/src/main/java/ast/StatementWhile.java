package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Représente une instruction de type while dans l'AST.
 * Une instruction while exécute un bloc d'instructions tant qu'une condition est vraie.
 */
public class StatementWhile extends Statement {
    private Condition condition;
    private Block block;

    /**
     * Constructeur de la classe StatementWhile.
     *
     * @param condition la condition à évaluer
     * @param block le bloc d'instructions à exécuter tant que la condition est vraie
     */
    public StatementWhile(Condition condition, Block block) {
        this.condition = condition;
        this.block = block;
    }

    /**
     * Retourne la condition de l'instruction while.
     *
     * @return la condition
     */
    public Condition getCondition() {
        return condition;
    }

    /**
     * Retourne le bloc d'instructions à exécuter tant que la condition est vraie.
     *
     * @return le bloc d'instructions
     */
    public Block getBlock() {
        return block;
    }

    /**
     * Accepte un visiteur pour effectuer une opération sur cette instruction while.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
