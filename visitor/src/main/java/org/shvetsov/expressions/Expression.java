package org.shvetsov.expressions;

import org.shvetsov.Operand;
import org.shvetsov.operators.OperatorNode;

public interface Expression {
    Operand getLvalue();

    OperatorNode getOperator();

    Operand getRvalue();
}
