package nl.benooms

import nl.benooms.splurthperiodictable.PeriodicTableService
import spock.lang.Specification
import spock.lang.Unroll


/**
 * Created by Ben Ooms on 11-8-2016.
 *
 */
class splurthperiodictableSpec extends Specification {

    def "Dummy test to check setup" () {
        expect:
            assert true
    }

    @Unroll
    def "Given a symbol: #symbol and a element: #element a validation result: #expectedResult is returned" (symbol, element, expectedResult) {
        when:
            def result = new PeriodicTableService().validateSymbol(symbol, element)
        then:
            assert result == expectedResult
        where:
            symbol  |   element           |   expectedResult
            "t"     |   "ether"           |   false //Length of symbol must be 2
            "123"   |   "ether"           |   false //Length of symbol must be 2
            ""      |   "ether"           |   false //Length of symbol must be 2
             null   |   "ether"           |   false //Length of symbol must be 2
            "az"    |   ""                |   false //Length of element must be 2 or higher
            "AZ"    |   "e"               |   false //Length of element must be 2 or higher
            "ZN"    |   null              |   false //Length of element must be 2  or higher
            "12"    |   "abd"             |   false // only a-z A-Z allowed
            "Ac"    |   "ab&"             |   false // only a-z A-Z allowed
            "ac"    |   "Qbq"             |   false // should start with uppercase
            "Ac"    |   "abq"             |   false // should start with uppercase
            "Zc"    |   "abq"             |   false // first symbol char not in element
            "Zc"    |   "Zbq"             |   false // second symbol char not in element
            "AB"    |   "YZAB"            |   true
            "AB"    |   "YZwAdfjkdvB"     |   true
            "AB"    |   "AdfjkdvB"        |   true
    }

}