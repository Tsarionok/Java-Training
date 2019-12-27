package by.tsarionok.controller;

import by.tsarionok.service.RomanToArabic;

public class Runner {
    public static void main(String[] args) {
        String roman2018 = "MMXVIII";

        RomanToArabic romanToArabic = new RomanToArabic();

        int result = romanToArabic.romanToArabic(roman2018);

        System.out.println(result);
    }
}
