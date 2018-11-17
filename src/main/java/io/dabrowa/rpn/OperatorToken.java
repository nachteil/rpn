package io.dabrowa.rpn;

import java.util.Stack;
import java.util.function.IntBinaryOperator;

class OperatorToken implements TokenAction {

    private final IntBinaryOperator operator;

    OperatorToken(IntBinaryOperator operator) {
        this.operator = operator;
    }

    @Override
    public void perform(Stack<Integer> stack) {
        int right = stack.pop();
        int left = stack.pop();
        stack.push(operator.applyAsInt(left, right));
    }
}
