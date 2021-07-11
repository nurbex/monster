package com.trading.monster.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class HIstoricalData {
    @Id
    AlpacaAsset ticker;

    List<OneMinuteBar> historicalData;

    public AlpacaAsset getTicker() {
        return ticker;
    }

    public void setTicker(AlpacaAsset ticker) {
        this.ticker = ticker;
    }

    public List<OneMinuteBar> getHistoricalData() {
        return historicalData;
    }

    public void setHistoricalData(List<OneMinuteBar> historicalData) {
        this.historicalData = historicalData;
    }
}
