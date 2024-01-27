package org.shvetsov.values;

import java.math.BigInteger;

public class BigIntegerValueNode extends ValueNode {

    public final BigInteger val;

    public BigIntegerValueNode(BigInteger val) {
        this.val = val;
    }

    @Override
    public BigInteger getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "BigIntegerValueNode{" +
                "val=" + val +
                '}';
    }
}
