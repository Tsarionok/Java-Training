package by.tsarionok.entity;

import java.util.Date;

public class Watched extends Entity {
    private User user;
    private Serial serial;
    private Date viewingDate;

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public Serial getSerial() {
        return serial;
    }

    public void setSerial(Serial serial) {
        this.serial = serial;
    }

    public Date getViewingDate() {
        return viewingDate;
    }

    public void setViewingDate(final Date date) {
        this.viewingDate = date;
    }
}

