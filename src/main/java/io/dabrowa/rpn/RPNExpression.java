package io.dabrowa.rpn;

import java.util.Optional;
import java.util.Stack;

public class RPNExpression {

    private final String input;

    public RPNExpression(final String input) {
        this.input = input;
    }

    public int value() {
        final Stack<Integer> stack = new Stack<>();
        final InputString inputParser = new InputString(input);
        Optional<Token> tokenOpt;
        while((tokenOpt = inputParser.nextToken()).isPresent()) {
            Token token = tokenOpt.get();
            if(token.isNumber()) {
                stack.push(token.numericValue());
            } else {
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(token.perform(left, right));
            }
        }
        if(stack.size() != 1) {
            throw new IllegalStateException("Malformed input - one item should be left on stack");
        }
        return stack.pop();
    }
}
