package io.dabrowa.rpn;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

class InputString {

    private final TokenMapping tokenMapping;
    private final String[] tokens;
    private int position = 0;

    public InputString(String input) {
        this.tokens = input.split(" ");
        this.tokenMapping = new TokenMapping();
    }

    public Optional<Token> nextToken() {
        int nextTokenPosition = position;
        position++;
        if(nextTokenPosition < tokens.length) {
            return tokenFromSymbol(tokens[nextTokenPosition]);
        }
        return Optional.empty();
    }

    private Optional<Token> tokenFromSymbol(String stringToken) {
        if (StringUtils.isNumeric(stringToken)) {
            return Optional.of(new NumberToken(stringToken));
        } else {
            Token token = this.tokenMapping.fromSymbol(stringToken);
            return Optional.of(token);
        }
    }
}
