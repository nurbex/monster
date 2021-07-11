package com.trading.monster.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OneMinuteBar {
    @Id
    Long t;//  "t": 1625674980,
    Double o;//  "o": 143.965,
    Double h;//  "h": 144.03,
    Double l;//  "l": 143.96,
    Double c;//  "c": 143.995,
    Long v;//  "v": 5241

    public Long getT() {
        return t;
    }

    public void setT(Long t) {
        this.t = t;
    }

    public Double getO() {
        return o;
    }

    public void setO(Double o) {
        this.o = o;
    }

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

    public Double getL() {
        return l;
    }

    public void setL(Double l) {
        this.l = l;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    public Long getV() {
        return v;
    }

    public void setV(Long v) {
        this.v = v;
    }
}
