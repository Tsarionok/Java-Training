package by.tsarionok.controller;

import by.tsarionok.entity.Time;
import by.tsarionok.service.TimeService;

public class Runner {
    public static void main(String[] args) {
        Time t = new Time(14, 18, 11);

        System.out.println("Установленное время  ");

        TimeService.showTime(t);

    }
}
