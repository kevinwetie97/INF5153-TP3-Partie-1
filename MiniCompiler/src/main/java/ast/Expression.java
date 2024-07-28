package main.java.ast;

import main.java.visitor.Visitor;

/**
 * Classe abstraite représentant une expression dans l'AST.
 * Cette classe est la superclasse de toutes les expressions spécifiques.
 */
public abstract class Expression {

    /**
     * Méthode abstraite acceptant un visiteur pour effectuer une opération sur cette expression.
     *
     * @param visitor le visiteur qui effectue l'opération
     */
    public abstract void accept(Visitor visitor);
}
