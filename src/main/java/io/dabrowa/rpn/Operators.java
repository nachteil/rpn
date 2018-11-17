package io.dabrowa.rpn;

import java.util.function.IntBinaryOperator;

class Operators {

    IntBinaryOperator fromString(String operatorSymbol) {
        switch (operatorSymbol) {
            case "+":
                return (left, right) -> left + right;
            case "-":
                return (left, right) -> left - right;
            case "*":
                return (left, right) -> left * right;
            case "/":
                return (left, right) -> left / right;
        }
        throw new IllegalArgumentException("Unknown symbol: " + operatorSymbol);
    }
}
