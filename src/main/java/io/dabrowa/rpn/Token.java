package io.dabrowa.rpn;

interface Token {
    boolean isNumber();
    boolean isOperator();
    int numericValue();
    int perform(int left, int right);
}
