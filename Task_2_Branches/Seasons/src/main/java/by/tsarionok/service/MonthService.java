package by.tsarionok.service;

import by.tsarionok.exception.MonthEnterException;

import static by.tsarionok.entity.Seasons.*;

public class MonthService {
    public String defineSeason(int monthNumber) throws MonthEnterException {
        String season = "";
        switch (monthNumber) {
            case 12:
            case 1:
            case 2:
                season = WINTER.getSeason();
                break;
            case 3:
            case 4:
            case 5:
                season = SPRING.getSeason();
                break;
            case 6:
            case 7:
            case 8:
                season = SUMMER.getSeason();
                break;
            case 9:
            case 10:
            case 11:
                season = AUTUMN.getSeason();
                break;
            default:
                throw new MonthEnterException("Month number " + monthNumber + " does not exist!");
        }
        return season;
    }
}
