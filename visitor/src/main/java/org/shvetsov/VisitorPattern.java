package org.shvetsov;

import org.shvetsov.expressions.Expression;
import org.shvetsov.expressions.MathExpression;
import org.shvetsov.operators.MultipleOperatorNode;
import org.shvetsov.operators.OperatorNode;
import org.shvetsov.operators.SumOperatorNode;
import org.shvetsov.values.BigIntegerValueNode;
import org.shvetsov.values.IntegerValueNode;
import org.shvetsov.values.ValueNode;

import java.math.BigInteger;
import java.util.Stack;

public class VisitorPattern {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //2+2*2
        AST ast = new MathExpression(new IntegerValueNode(2), new SumOperatorNode(), new MathExpression(new IntegerValueNode(2), new MultipleOperatorNode(), new IntegerValueNode(2)));
        countBackward(ast);

        AST converted = convertAST(ast);
        countBackward(converted);
    }

    private static AST convertAST(AST ast) {
        Stack<AST> stack = new Stack<>();
        ast.accept(new Visitor() {
            @Override
            public void visitValue(ValueNode node) {
                if (node instanceof IntegerValueNode) {
                    stack.push(new BigIntegerValueNode(BigInteger.valueOf((Integer) node.getVal())));
                } else if (node instanceof BigIntegerValueNode) {
                    BigInteger val = (BigInteger) node.getVal();
                    if (val.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 || val.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
                        throw new UnsupportedOperationException("Can't convert so big value");
                    } else {
                        stack.push(new IntegerValueNode(val.intValue()));
                    }
                }
            }

            @Override
            public void visitOperator(OperatorNode node) {
                stack.push(node);
            }

            @Override
            public void visitExpression(Expression node) {
                node.getLvalue().accept(this);
                node.getOperator().accept(this);
                node.getRvalue().accept(this);


                Operand rvalue = (Operand) stack.pop();
                OperatorNode op = (OperatorNode) stack.pop();
                Operand lvalue = (Operand) stack.pop();
                stack.push(new MathExpression(lvalue, op, rvalue));
            }
        });
        return stack.pop();
    }

    private static void countBackward(AST ast) {
        Stack<Object> stack = new Stack<>();
        ast.accept(new Visitor() {
            @Override
            public void visitValue(ValueNode node) {
                stack.push(node.getVal());
            }

            @Override
            public void visitOperator(OperatorNode node) {
                stack.push(node.operate(stack.pop(), stack.pop()));
            }

            @Override
            public void visitExpression(Expression node) {
                node.getLvalue().accept(this);
                node.getRvalue().accept(this);
                node.getOperator().accept(this);
            }
        });
        Object last = stack.pop();
        System.out.printf("Value: %s, %s", last, last.getClass());
        System.out.println();
    }
}