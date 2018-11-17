package io.dabrowa.rpn;

class TokenMapping {

    Token fromSymbol(String symbol) {
        switch (symbol) {
            case "+":
                return (new OperatorToken((a,b) -> a+b));
            case "*":
                return (new OperatorToken((a,b) -> a*b));
            case "-":
                return (new OperatorToken((a,b) -> a-b));
            case "/":
                return (new OperatorToken((a,b) -> a/b));
        }
        throw new IllegalArgumentException("Symbol not supported: " + symbol);
    }
}
