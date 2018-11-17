package io.dabrowa.rpn

import spock.lang.Specification

class RPNSpec extends Specification {

    def "evaluates RPN expression"() {
        expect:
            new RPN(new Operators()).evaluationResult('12 2 3 4 * 10 5 / + * +') == 40
    }
}
