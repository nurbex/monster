package com.trading.monster.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CalendarDay {
    @Id
    private String date;
    private String open;
    private String close;
    private String session_open;
    private String session_close;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getSession_open() {
        return session_open;
    }

    public void setSession_open(String session_open) {
        this.session_open = session_open;
    }

    public String getSession_close() {
        return session_close;
    }

    public void setSession_close(String session_close) {
        this.session_close = session_close;
    }
}
