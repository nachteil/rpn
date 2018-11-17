package io.dabrowa.rpn;

public class NumberToken implements Token {

    private final String token;

    public NumberToken(String token) {
        this.token = token;
    }

    @Override
    public boolean isNumber() {
        return true;
    }

    @Override
    public boolean isOperator() {
        return false;
    }

    @Override
    public int numericValue() {
        return Integer.valueOf(token);
    }

    @Override
    public int perform(int left, int right) {
        throw new UnsupportedOperationException("This is number, not a token");
    }
}
