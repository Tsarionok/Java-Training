package by.tsarionok.view;

import by.tsarionok.entity.Calendar;

public class Viewer {
    public void printAllHolidaysFromCalendar(Calendar calendar) {
        System.out.printf("All holidays of %d year:\n", calendar.getYear());
        for (int i = 0; i < calendar.getHolidays().length; i++) {
            System.out.printf("%s\t%s\n", calendar.getHolidays()[i].getDate().toString(), calendar.getHolidays()[i].getName());
        }
    }
}
