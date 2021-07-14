package com.trading.monster.domain;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.List;

public class HistoricalData {

    List<OneMinuteBar> bars;

    String symbol="AAPL"; //  "symbol": "AAPL",
    String next_page_token=null; //  "next_page_token": "MjAyMS0wMi0wMVQxNDowMjowMFo7MQ=="

    @JsonGetter("bars")
    public List<OneMinuteBar> getBars() {
        return bars;
    }

    public void setBars(List<OneMinuteBar> bars) {
        this.bars = bars;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getNext_page_token() {
        return next_page_token;
    }

    public void setNext_page_token(String next_page_token) {
        this.next_page_token = next_page_token;
    }

    @Override
    public String toString() {
        return "HistoricalData{" +
                "AAPL=" + bars +
                '}';
    }
}
