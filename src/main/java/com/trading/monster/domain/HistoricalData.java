package com.trading.monster.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.List;

public class HistoricalData {

    List<OneMinuteBar> AAPL;

    @JsonGetter("AAPL")
    public List<OneMinuteBar> getAAPL() {
        return AAPL;
    }

    public void setAAPL(List<OneMinuteBar> AAPL) {
        this.AAPL = AAPL;
    }

    @Override
    public String toString() {
        return "HistoricalData{" +
                "AAPL=" + AAPL +
                '}';
    }
}
