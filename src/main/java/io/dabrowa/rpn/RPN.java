package io.dabrowa.rpn;

import java.util.Optional;
import java.util.Stack;

public class RPN {

    private final Operators operators;

    public RPN(final Operators operators) {
        this.operators = operators;
    }

    public int evaluationResult(final String rpnString) {
        final RPNExpression expression = new RPNExpression(rpnString, operators);
        Optional<TokenAction> nextTokenAction = expression.nextToken();
        final Stack<Integer> stack = new Stack<>();
        while(nextTokenAction.isPresent()) {
            nextTokenAction.get().perform(stack);
            nextTokenAction = expression.nextToken();
        }
        if(stack.size() != 1) {
            throw new IllegalArgumentException("Processing error - is your RPN expressions malformed?");
        }
        return stack.pop();
    }
}
