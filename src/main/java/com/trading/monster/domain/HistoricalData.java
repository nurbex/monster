package com.trading.monster.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class HistoricalData {

    List<OneMinuteBar> AAPL;

    @JsonAlias({ "AAPL" })
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
