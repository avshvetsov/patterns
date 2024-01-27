package org.shvetsov;

public interface AST {
    void accept(Visitor visitor);
}
