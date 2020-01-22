package by.tsarionok.entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Calendar {
    private Holiday[] holidays = new Holiday[0];
    private int year;


    public Calendar() {
        super();
        year = LocalDate.now().getYear();
    }


    public Calendar(int year) {
        super();
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (this.year == year) {
            return;
        }

        this.year = year;
        holidays = new Holiday[0];
    }

    public Holiday[] getHolidays() {
        return holidays;
    }

    public void setHolidays(Holiday[] holidays) {
        this.holidays = holidays;
    }

    public void setHolidays(Holiday holiday) {

        int indexBefore = -1;

        for (int i = 0; i < holidays.length; i++) {

            if (holidays[i].getDate().equals(holiday.getDate())) {
                holidays[i] = holiday;
                return;
            }

            if (holidays[i].getDate().isBefore(holiday.getDate())) {
                indexBefore = i;
            }
        }

        Holiday[] temp = new Holiday[holidays.length + 1];
        System.arraycopy(holidays, 0, temp, 0, indexBefore + 1);
        temp[indexBefore + 1] = holiday;
        System.arraycopy(holidays, indexBefore + 1, temp, indexBefore + 2, holidays.length - indexBefore - 1);

        setHolidays(temp);
    }

    @Override
    public String toString() {
        return "holidays: " + Arrays.toString(holidays) + " of the " + year + " year";
    }

    public class Holiday {

        String name;
        LocalDate date;

        public Holiday(String name, int month, int day) {
            this.name = name;
            this.date = LocalDate.of(year, month, day);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(int month, int day) {
            this.date = LocalDate.of(year, month, day);
        }

        @Override
        public String toString() {
            return "Holiday: " + name + ", date:" + date;
        }

    }
}
