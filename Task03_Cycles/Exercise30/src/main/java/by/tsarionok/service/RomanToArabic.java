package by.tsarionok.service;


import by.tsarionok.entity.RomanNum;

import java.util.List;

public class RomanToArabic {
    public int romanToArabic(String input) {
        String romanNum = input.toUpperCase();
        int result = 0;

        List<RomanNum> romanNumerals = RomanNum.getReverseSortedValues();

        int i = 0;

        while ((romanNum.length() > 0) && (i < romanNumerals.size())) {
            RomanNum symbol = romanNumerals.get(i);
            if (romanNum.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNum = romanNum.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNum.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }

        return result;
    }
}
