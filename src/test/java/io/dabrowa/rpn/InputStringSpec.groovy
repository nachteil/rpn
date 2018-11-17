package io.dabrowa.rpn

import spock.lang.Specification

class InputStringSpec extends Specification {

    def "parses single number"() {

        given:
            def sut = new InputString(input)

        when:
            def token = sut.nextToken()

        then:
            token.isPresent()
            token.get().isNumber()
            token.get().numericValue() == Integer.valueOf(input)

        where:
            input << ['123', '1', '8']
    }

    def "parses sequence of numbers"() {

        given:
            def sut = new InputString('123 1 8')

        expect:
            with(sut.nextToken()) {
                it.present
                it.get().number
                it.get().numericValue() == 123
            }
            with(sut.nextToken()) {
                it.present
                it.get().number
                it.get().numericValue() == 1
            }
            with(sut.nextToken()) {
                it.present
                it.get().number
                it.get().numericValue() == 8
            }
        with(sut.nextToken()) {
            !it.present
        }
    }

    def "parses single operator"() {

        given:
            def sut = new InputString('*')

        when:
            def token = sut.nextToken()

        then:
            token.present
            !token.get().number
            token.get().operator
    }

    def "parses correct operators"() {

        given:
            def sut = new InputString('* + / -')

        expect:
            with(sut.nextToken().get()) {
                !it.number
                it.operator
                it.perform(2, 5) == 10
            }
            with(sut.nextToken().get()) {
                !it.number
                it.operator
                it.perform(2, 5) == 7
            }
            with(sut.nextToken().get()) {
                !it.number
                it.operator
                it.perform(2, 5) == 0
            }
            with(sut.nextToken().get()) {
                !it.number
                it.operator
                it.perform(2, 5) == -3
            }
    }

    def "throws exception for unknown symbol"() {
        given:
            def sut = new InputString(symbol)

        when:
            sut.nextToken()

        then:
            def e = thrown(IllegalArgumentException)
            e.message == "Symbol not supported: $symbol"

        where:
            symbol << ['%', '#', 'dupa']
    }
}
