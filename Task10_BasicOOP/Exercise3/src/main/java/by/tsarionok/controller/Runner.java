package by.tsarionok.controller;

import by.tsarionok.entity.Calendar;
import by.tsarionok.service.CalendarService;
import by.tsarionok.view.Viewer;

public class Runner {
    public static void main(String[] args) {
        Calendar calendar = new Calendar(2020);
        CalendarService calendarService = new CalendarService(calendar);
        Viewer view = new Viewer();

        calendarService.addAllDefaultWeekend();

        System.out.printf("Amount of holidays in %d year is %d\n",
                calendar.getYear(), calendarService.numberOfHolidaysInYear());

        calendarService.addHoliday("Новый Год", 1, 1);
        calendarService.addHoliday("8 Марта", 3, 8);
        calendarService.addHoliday("1 Апреля", 4, 1);
        calendarService.addHoliday("ДР", 11, 11);

        view.printAllHolidaysFromCalendar(calendar);
        System.out.println();

        calendarService.deleteHoliday(5, 1);

        view.printAllHolidaysFromCalendar(calendar);
    }
}
