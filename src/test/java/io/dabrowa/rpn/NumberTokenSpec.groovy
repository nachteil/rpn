package io.dabrowa.rpn

import spock.lang.Specification

class NumberTokenSpec extends Specification {

    def "pushes integer value to the stack"() {

        given:
            def sut = new NumberToken("$token")
            def stack = new Stack<Integer>()

        when:
            sut.perform(stack)

        then:
            stack.size() == 1
            stack.pop() == token

        where:
            token << [-1, 1, 0, 100, 123, 55]
    }
}
