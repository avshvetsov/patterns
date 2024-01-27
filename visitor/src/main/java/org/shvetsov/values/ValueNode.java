package org.shvetsov.values;

import org.shvetsov.Operand;
import org.shvetsov.Visitor;

public abstract class ValueNode implements Operand, Value {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitValue(this);
    }


}
