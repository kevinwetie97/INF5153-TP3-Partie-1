package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Représente l'unité de compilation dans l'AST.
 * Une unité de compilation est l'élément racine qui contient un bloc d'instructions.
 */
public class UnitCompilation extends Statement {
    private Block block;

    /**
     * Constructeur de la classe UnitCompilation.
     *
     * @param block le bloc d'instructions principal de l'unité de compilation
     */
    public UnitCompilation(Block block) {
        this.block = block;
    }

    /**
     * Retourne le bloc d'instructions principal de l'unité de compilation.
     *
     * @return le bloc d'instructions
     */
    public Block getBlock() {
        return block;
    }

    /**
     * Accepte un visiteur pour effectuer une opération sur cette unité de compilation.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
