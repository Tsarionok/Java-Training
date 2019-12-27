package by.tsarionok.service;

import by.tsarionok.entity.Date;
import by.tsarionok.entity.Month;
import by.tsarionok.exception.DateFormatException;
import by.tsarionok.exception.NullDateException;

public class DateManager {
    private final int MAX_DAYS_FEBRUARY_NO_LEAP = 28;
    private final int FIRST_MOUTH_DAY = 1;

    private Date date;

    public DateManager(Date date) {
        this.date = date;
    }

    public boolean isLeap() {
        if (date.getYear() % 400 == 0) {
            return true;
        }
        return date.getYear() % 4 == 0 && date.getYear() % 100 != 0;
    }

    public Date nextDate () {
        Date tomorrow = date;
        try {
            if (date != null) {
                try {
                    if (date.getMonth() == Month.FEBRUARY && !isLeap() && date.getDay() == 29) {
                        throw new  DateFormatException();
                    }
                    if (date.getDay() > 0 && date.getDay() <= date.getMonth().getMaxDaysNumber() && date.getYear() > 0) {
                        if (date.getMonth() == Month.DECEMBER && date.getDay() == Month.DECEMBER.getMaxDaysNumber()) {
                            tomorrow.setYear(date.getYear() + 1);
                            tomorrow.setMonth(Month.JANUARY);
                            tomorrow.setDay(FIRST_MOUTH_DAY);
                        } else if (date.getMonth().getMaxDaysNumber() <= date.getDay()) {
                            if (date.getMonth() == Month.FEBRUARY && isLeap() && date.getDay() == MAX_DAYS_FEBRUARY_NO_LEAP) {
                                tomorrow.setDay(Month.FEBRUARY.getMaxDaysNumber());
                            } else {
                                tomorrow.setMonth(Month.values()[date.getMonth().getMonthNumber()]);
                                tomorrow.setDay(FIRST_MOUTH_DAY);
                            }
                        }
                        else {
                            tomorrow.setDay(date.getDay() + 1);
                        }
                    } else {
                        throw new DateFormatException();
                    }
                }
                catch (DateFormatException formatException) {
                    formatException.printStackTrace();
                }
            } else {
                throw new NullDateException();
            }
        }
        catch (NullDateException exception) {
            exception.printStackTrace();
        }
        return tomorrow;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
