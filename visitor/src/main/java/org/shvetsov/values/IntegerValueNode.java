package org.shvetsov.values;

public class IntegerValueNode extends ValueNode {

    public final Integer val;

    public IntegerValueNode(Integer val) {
        this.val = val;
    }

    @Override
    public Integer getVal() {
        return val;
    }

    @Override
    public String toString() {
        return "IntegerValueNode{" +
                "val=" + val +
                '}';
    }
}
