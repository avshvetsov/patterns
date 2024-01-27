package org.shvetsov;

import org.shvetsov.expressions.Expression;
import org.shvetsov.operators.OperatorNode;
import org.shvetsov.values.ValueNode;

public interface Visitor {
    void visitValue(ValueNode node);
    void visitOperator(OperatorNode node);
    void visitExpression(Expression node);
}
