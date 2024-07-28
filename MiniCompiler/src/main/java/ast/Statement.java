package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Classe abstraite représentant une instruction dans l'AST.
 * Cette classe est la superclasse de toutes les instructions spécifiques.
 */
public abstract class Statement {

    /**
     * Méthode abstraite acceptant un visiteur pour effectuer une opération sur cette instruction.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    public abstract void accept(Visitor visitor);
}
