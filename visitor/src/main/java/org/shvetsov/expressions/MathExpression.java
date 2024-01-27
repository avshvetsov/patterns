package org.shvetsov.expressions;

import org.shvetsov.Operand;
import org.shvetsov.Visitor;
import org.shvetsov.operators.OperatorNode;

public class MathExpression implements Operand, Expression {

    public final Operand lvalue;
    public final OperatorNode operator;
    public final Operand rvalue;

    public MathExpression(Operand lvalue, OperatorNode operator, Operand rvalue) {
        this.lvalue = lvalue;
        this.operator = operator;
        this.rvalue = rvalue;
    }

    @Override
    public Operand getLvalue() {
        return lvalue;
    }

    @Override
    public OperatorNode getOperator() {
        return operator;
    }

    @Override
    public Operand getRvalue() {
        return rvalue;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitExpression(this);
    }

    @Override
    public String toString() {
        return "MathExpression{" +
                "lvalue=" + lvalue +
                ", operator=" + operator +
                ", rvalue=" + rvalue +
                '}';
    }
}
