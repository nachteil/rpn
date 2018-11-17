package io.dabrowa.rpn;

import java.util.Stack;

class NumberToken implements TokenAction {

    private final String token;

    NumberToken(String token) {
        this.token = token;
    }

    @Override
    public void perform(Stack<Integer> stack) {
        stack.push(Integer.valueOf(token));
    }
}
