package nl.benooms.splurthperiodictable;

import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by Ben Ooms on 11-8-2016.
 */
public class PeriodicTableService {

    public boolean validateSymbol(String symbol, String element){
        boolean validInput = Stream.of(symbol, element)
                                .allMatch(val-> Objects.nonNull(val) && Pattern.matches("^[A-Z]+[a-zA-Z]+",val));

        return validInput && assertSymbolValidity(symbol, element);
    }

    private boolean assertSymbolValidity(String symbol, String element) {
        if (symbol.length() != 2 || element.length() < 2) return false;
        String symbolUpperCase = symbol.toUpperCase();
        String elementToUpperCase = element.toUpperCase();
        int indexOfFirstLetter = elementToUpperCase.indexOf(symbolUpperCase.charAt(0));
        char secondLetter = symbolUpperCase.charAt(1);
        if (indexOfFirstLetter >= 0 && indexOfFirstLetter < element.length() - 1) {
            return elementToUpperCase.substring(indexOfFirstLetter).chars()
                    .anyMatch(ch->ch == secondLetter);
        } else {
            return false;
        }
    }
}
