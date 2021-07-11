package com.trading.monster.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class HistoricalData {
    @Id
    String ticker;

    List<OneMinuteBar> historicalData;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public List<OneMinuteBar> getHistoricalData() {
        return historicalData;
    }

    public void setHistoricalData(List<OneMinuteBar> historicalData) {
        this.historicalData = historicalData;
    }
}
