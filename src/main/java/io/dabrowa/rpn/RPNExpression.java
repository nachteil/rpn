package io.dabrowa.rpn;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

class RPNExpression {

    private final Operators operators;
    private final Lazy<String[]> inputSplit;

    private int position;

    public RPNExpression(final String expressionString, final Operators operators) {
        this.inputSplit = new Lazy<>(() -> expressionString.split(" "));
        this.position = 0;
        this.operators = operators;
    }

    Optional<TokenAction> nextToken() {
        if(parsedWholeInput()) {
            return Optional.empty();
        }
        final int nextPosition = position;
        position += 1;
        return actionFromToken(inputSplit.get()[nextPosition]);
    }

    private boolean parsedWholeInput() {
        return position == inputSplit.get().length;
    }

    private Optional<TokenAction> actionFromToken(String token) {
        if(StringUtils.isNumeric(token)) {
            return Optional.of(new NumberToken(token));
        } else {
            return Optional.of(new OperatorToken(operators.fromString(token)));
        }
    }
}
