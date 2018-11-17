package io.dabrowa.rpn

import spock.lang.Specification

class OperatorTokenSpec extends Specification {

    def "applies operator"() {

        given:
            def sut = new OperatorToken(operator)
            def stack = new Stack<Integer>()
            stack.push(4)
            stack.push(6)

        when:
            sut.perform(stack)

        then:
            stack.size() == 1
            stack.pop() == result

        where:
            operator          | result
            { a, b -> a + b } | 10
            { a, b -> a * b } | 24
            { a, b -> a - b } | -2
    }
}
