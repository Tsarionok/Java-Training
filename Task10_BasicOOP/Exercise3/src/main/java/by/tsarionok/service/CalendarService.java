package by.tsarionok.service;

import by.tsarionok.entity.Calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class CalendarService {
    private Calendar calendar;

    public CalendarService(Calendar calendar) {
        super();
        this.calendar = calendar;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void addAllDefaultWeekend() {
        LocalDate tempDate = LocalDate.of(calendar.getYear(), 1, 1);
        while (tempDate.getYear() == calendar.getYear()) {
            if ((tempDate.getDayOfWeek() == DayOfWeek.SATURDAY) || (tempDate.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                Calendar.Holiday tempHoliday = calendar.new Holiday("Weekend " +
                        tempDate.getDayOfWeek().toString().toLowerCase(), tempDate.getMonthValue(), tempDate.getDayOfMonth());
                calendar.setHolidays(tempHoliday);
            }
            tempDate = tempDate.plusDays(1);
        }
    }

    public void addHoliday(String name, int month, int day) {
        Calendar.Holiday tempHoliday = calendar.new Holiday(name, month, day);
        calendar.setHolidays(tempHoliday);
    }

    public void deleteHoliday(int month, int day) {
        boolean flagDelete = false;
        Calendar.Holiday[] tempHolidays = calendar.getHolidays();
        for (int i = 0; i < tempHolidays.length - 1; i++) {
            if (tempHolidays[i].getDate().equals(LocalDate.of(calendar.getYear(), month, day))) {
                flagDelete = true;
            }
            if (flagDelete) {
                tempHolidays[i] = tempHolidays[i + 1];
            }
        }
        if (tempHolidays[tempHolidays.length - 1].getDate().equals(LocalDate.of(calendar.getYear(), month, day))) {
            flagDelete = true;
        }
        if (flagDelete) {
            tempHolidays = Arrays.copyOf(tempHolidays, tempHolidays.length - 1);
        }
        calendar.setHolidays(tempHolidays);
    }

    public int numberOfHolidaysInYear() {
        return calendar.getHolidays().length;
    }

    public void cleanHolidays() {
        calendar.setHolidays(new Calendar.Holiday[0]);
    }

}
