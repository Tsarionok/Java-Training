package by.tsarionok.controller;

import by.tsarionok.entity.Date;
import by.tsarionok.entity.Month;
import by.tsarionok.service.DateManager;

import static by.tsarionok.entity.Month.*;

public class Runner {
    public static void main(String[] args) {
        Date date1 = new Date(2020, FEBRUARY, 28);
        Date date2 = new Date(2020, FEBRUARY, 29);
        Date date3 = new Date(2019, FEBRUARY, 28);
        Date date4 = new Date(2019, FEBRUARY, 29); // not validate
        Date date5 = new Date(2019, DECEMBER, 31);
        Date date6 = new Date(2008, DECEMBER, 31);
        Date date7 = new Date(2007, JANUARY, 1);
        Date date8 = new Date(2017, MARCH, 4);
        Date date9 = new Date(1999, NOVEMBER, 11);
        Date date10 = new Date(-400, NOVEMBER, 11); // not validate
        Date date11 = new Date(1999, NOVEMBER, -2); // not validate
        Date date12 = new Date(1999, NOVEMBER, 54); // not validate


        System.out.println(new DateManager(date1).nextDate());
        System.out.println(new DateManager(date2).nextDate());
        System.out.println(new DateManager(date3).nextDate());
        System.out.println(new DateManager(date4).nextDate());
        System.out.println(new DateManager(date5).nextDate());
        System.out.println(new DateManager(date6).nextDate());
        System.out.println(new DateManager(date7).nextDate());
        System.out.println(new DateManager(date8).nextDate());
        System.out.println(new DateManager(date9).nextDate());
        System.out.println(new DateManager(date10).nextDate());
        System.out.println(new DateManager(date11).nextDate());
        System.out.println(new DateManager(date12).nextDate());

    }
}
