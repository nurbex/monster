package com.trading.monster.domain;

import com.fasterxml.jackson.annotation.JsonAlias;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AlpacaAsset {
    @Id
    private String id; //"id": "c8024b9e-d4cf-4afe-a8d9-2fa2d7ed73ac",
    @JsonAlias({ "class" })
    private String asset_class; //"class": "us_equity",
    private String exchange; //"exchange": "NYSE",
    private String symbol; //"symbol": "NIO",
    private String name; //"name": "NIO Inc. American depositary shares, each representing one Class A ordinary share",
    private String status; //"status": "active",
    private boolean tradable; //"tradable": true,
    private boolean marginable; //"marginable": true,
    private boolean shortable; //"shortable": true,
    private boolean easy_to_borrow; //"easy_to_borrow": true,
    private boolean fractionable; //"fractionable": true

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAsset_class() {
        return asset_class;
    }

    public void setAsset_class(String asset_class) {
        this.asset_class = asset_class;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isTradable() {
        return tradable;
    }

    public void setTradable(boolean tradable) {
        this.tradable = tradable;
    }

    public boolean isMarginable() {
        return marginable;
    }

    public void setMarginable(boolean marginable) {
        this.marginable = marginable;
    }

    public boolean isShortable() {
        return shortable;
    }

    public void setShortable(boolean shortable) {
        this.shortable = shortable;
    }

    public boolean isEasy_to_borrow() {
        return easy_to_borrow;
    }

    public void setEasy_to_borrow(boolean easy_to_borrow) {
        this.easy_to_borrow = easy_to_borrow;
    }

    public boolean isFractionable() {
        return fractionable;
    }

    public void setFractionable(boolean fractionable) {
        this.fractionable = fractionable;
    }

    @Override
    public String toString() {
        return "AlpacaAsset{" +
                "id='" + id + '\'' +
                ", asset_class='" + asset_class + '\'' +
                ", exchange='" + exchange + '\'' +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", tradable=" + tradable +
                ", marginable=" + marginable +
                ", shortable=" + shortable +
                ", easy_to_borrow=" + easy_to_borrow +
                ", fractionable=" + fractionable +
                '}';
    }
}
