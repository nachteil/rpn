package io.dabrowa.rpn

import spock.lang.Specification

class RPNExpressionSpec extends Specification {

    def "computes result"() {

        given:
            def sut = new RPNExpression('12 2 3 4 * 10 5 / + * +')

        expect:
            sut.value() == 40
    }
}
