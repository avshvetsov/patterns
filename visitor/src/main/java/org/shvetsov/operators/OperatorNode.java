package org.shvetsov.operators;

import org.shvetsov.AST;
import org.shvetsov.Visitor;

public abstract class OperatorNode implements AST, Operator {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitOperator(this);
    }
}
