package io.dabrowa.rpn;

import java.util.Stack;

interface TokenAction {

    void perform(Stack<Integer> stack);
}
