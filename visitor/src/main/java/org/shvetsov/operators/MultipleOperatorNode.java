package org.shvetsov.operators;

import java.math.BigInteger;

public class MultipleOperatorNode extends OperatorNode {

    public final String sign = "*";

    public Object operate(Object lvalue, Object rvalue) {
        if (lvalue instanceof Integer) {
            return (Integer) lvalue * (Integer) rvalue;
        } else if (lvalue instanceof BigInteger) {
            return ((BigInteger) lvalue).multiply((BigInteger) rvalue);
        }
        return null;
    }

    @Override
    public String toString() {
        return sign;
    }
}
