package by.tsarionok.service;

import by.tsarionok.entity.Time;

public class TimeService {
    public static void showTime(Time t) {
        if ((0 <= t.getHour()) && (t.getHour() < 24)) {
            t.getHour();
        } else {
            t.setHour(0);
            System.out.println("Неверное значение установки часа, сброс в 0");
        }

        if ((0 <= t.getMin()) && (t.getMin() < 60)) {
            t.getMin();
        } else {
            t.setMin(0);
            System.out.println("Неверное значение установки минуты, сброс в 0");
        }

        if ((0 <= t.getSec()) && (t.getSec() < 60)) {
            t.getSec();
        } else {
            t.setSec(0);
            System.out.println("Неверное значение установки секунды, сброс в 0");
        }
        System.out.println(t.getHour() + ":" + t.getMin() + ":" + t.getSec());

    }

}
