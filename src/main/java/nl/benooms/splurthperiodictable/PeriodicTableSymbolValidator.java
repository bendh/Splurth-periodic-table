package nl.benooms.splurthperiodictable;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by Ben Ooms on 11-8-2016.
 */
public class PeriodicTableSymbolValidator {

    public boolean validateSymbol(String symbol, String element){
        boolean validInput = Stream.of(symbol, element)
                                .allMatch(val-> Objects.nonNull(val) && Pattern.matches("^[A-Z]+[a-zA-Z]{1,}",val));
        if (validInput) {
            return assertSymbolValidity(symbol, element);
        } else {
            return validInput;
        }
    }

    private boolean assertSymbolValidity(String symbol, String element) {
        if (symbol.length() != 2) return false;
        return true;
    }
}
