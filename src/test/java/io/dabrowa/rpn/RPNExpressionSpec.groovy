package io.dabrowa.rpn

import spock.lang.Specification

class RPNExpressionSpec extends Specification {

    def operator = new Operators()

    def "parses numbers"() {

        given:
            def sut = new RPNExpression('1 2 3 4 5', operator)
            def stack = new Stack()

        when:
            5.times {
                sut.nextToken().get().perform(stack)
            }

        then:
            stack.size() == 5
            stack.pop() == 5
            stack.pop() == 4
            stack.pop() == 3
            stack.pop() == 2
            stack.pop() == 1
    }

    def "returns empty optional when parsed input"() {

        given:
            def sut = new RPNExpression('1', operator)
            sut.nextToken()

        when:
            def shouldBeEmpty = sut.nextToken()

        then:
            !shouldBeEmpty.present
    }
}
