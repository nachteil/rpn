package io.dabrowa.rpn;

import java.util.function.IntBinaryOperator;

class OperatorToken implements Token {

    private final IntBinaryOperator operator;

    public OperatorToken(IntBinaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public boolean isNumber() {
        return false;
    }

    @Override
    public boolean isOperator() {
        return true;
    }

    @Override
    public int numericValue() {
        throw new UnsupportedOperationException("This is an operator, not a number");
    }

    @Override
    public int perform(int left, int right) {
        return operator.applyAsInt(left, right);
    }
}
