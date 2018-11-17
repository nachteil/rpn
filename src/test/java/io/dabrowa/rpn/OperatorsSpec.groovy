package io.dabrowa.rpn

import spock.lang.Specification

class OperatorsSpec extends Specification {

    def "creates supported operators"() {

        given:
            def sut = new Operators()

        expect:
            sut.fromString(symbol).applyAsInt(left, right) == result

        where:
            symbol | left | right | result
            '+'    | 1    | 5     | 6
            '+'    | 3    | 8     | 11
            '-'    | 1    | 5     | -4
            '-'    | 3    | 8     | -5
            '*'    | 1    | 5     | 5
            '*'    | 3    | 8     | 24
            '/'    | 1    | 5     | 0
            '/'    | 3    | 8     | 0
            '/'    | 7    | 3     | 2
    }
}
