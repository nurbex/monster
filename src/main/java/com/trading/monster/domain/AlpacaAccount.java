package com.trading.monster.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AlpacaAccount {
    @Id
    private String id; //"id": "4e26d014-4864-41f5-913f-319f589e2cea",
    private String account_number; //"account_number": "933212942",
    private String status; //"status": "ACTIVE",
    private String currency; //"currency": "USD",
    private String buying_power; //"buying_power": "0",
    private String regt_buying_power; //"regt_buying_power": "0",
    private String daytrading_buying_power; //"daytrading_buying_power": "0",
    private String cash; //"cash": "0",
    private String portfolio_value; //"portfolio_value": "0",
    private boolean pattern_day_trader; //"pattern_day_trader": false,
    private boolean trading_blocked; //"trading_blocked": false,
    private boolean transfers_blocked; //"transfers_blocked": false,
    private boolean account_blocked; //"account_blocked": false,
    private String created_at; //"created_at": "2021-04-27T17:13:31.628868Z",
    private boolean trade_suspended_by_user; //"trade_suspended_by_user": false,
    private String multiplier; //"multiplier": "1",
    private boolean shorting_enabled; //"shorting_enabled": false,
    private String equity; //"equity": "0",
    private String last_equity; //"last_equity": "0",
    private String long_market_value; //"long_market_value": "0",
    private String short_market_value; //"short_market_value": "0",
    private String initial_margin; //"initial_margin": "0",
    private String maintenance_margin; //"maintenance_margin": "0",
    private String last_maintenance_margin; //"last_maintenance_margin": "0",
    private String sma; //"sma": "0",
    private Integer daytrade_count; //"daytrade_count": 0

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBuying_power() {
        return buying_power;
    }

    public void setBuying_power(String buying_power) {
        this.buying_power = buying_power;
    }

    public String getRegt_buying_power() {
        return regt_buying_power;
    }

    public void setRegt_buying_power(String regt_buying_power) {
        this.regt_buying_power = regt_buying_power;
    }

    public String getDaytrading_buying_power() {
        return daytrading_buying_power;
    }

    public void setDaytrading_buying_power(String daytrading_buying_power) {
        this.daytrading_buying_power = daytrading_buying_power;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getPortfolio_value() {
        return portfolio_value;
    }

    public void setPortfolio_value(String portfolio_value) {
        this.portfolio_value = portfolio_value;
    }

    public boolean isPattern_day_trader() {
        return pattern_day_trader;
    }

    public void setPattern_day_trader(boolean pattern_day_trader) {
        this.pattern_day_trader = pattern_day_trader;
    }

    public boolean isTrading_blocked() {
        return trading_blocked;
    }

    public void setTrading_blocked(boolean trading_blocked) {
        this.trading_blocked = trading_blocked;
    }

    public boolean isTransfers_blocked() {
        return transfers_blocked;
    }

    public void setTransfers_blocked(boolean transfers_blocked) {
        this.transfers_blocked = transfers_blocked;
    }

    public boolean isAccount_blocked() {
        return account_blocked;
    }

    public void setAccount_blocked(boolean account_blocked) {
        this.account_blocked = account_blocked;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public boolean isTrade_suspended_by_user() {
        return trade_suspended_by_user;
    }

    public void setTrade_suspended_by_user(boolean trade_suspended_by_user) {
        this.trade_suspended_by_user = trade_suspended_by_user;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }

    public boolean isShorting_enabled() {
        return shorting_enabled;
    }

    public void setShorting_enabled(boolean shorting_enabled) {
        this.shorting_enabled = shorting_enabled;
    }

    public String getEquity() {
        return equity;
    }

    public void setEquity(String equity) {
        this.equity = equity;
    }

    public String getLast_equity() {
        return last_equity;
    }

    public void setLast_equity(String last_equity) {
        this.last_equity = last_equity;
    }

    public String getLong_market_value() {
        return long_market_value;
    }

    public void setLong_market_value(String long_market_value) {
        this.long_market_value = long_market_value;
    }

    public String getShort_market_value() {
        return short_market_value;
    }

    public void setShort_market_value(String short_market_value) {
        this.short_market_value = short_market_value;
    }

    public String getInitial_margin() {
        return initial_margin;
    }

    public void setInitial_margin(String initial_margin) {
        this.initial_margin = initial_margin;
    }

    public String getMaintenance_margin() {
        return maintenance_margin;
    }

    public void setMaintenance_margin(String maintenance_margin) {
        this.maintenance_margin = maintenance_margin;
    }

    public String getLast_maintenance_margin() {
        return last_maintenance_margin;
    }

    public void setLast_maintenance_margin(String last_maintenance_margin) {
        this.last_maintenance_margin = last_maintenance_margin;
    }

    public String getSma() {
        return sma;
    }

    public void setSma(String sma) {
        this.sma = sma;
    }

    public Integer getDaytrade_count() {
        return daytrade_count;
    }

    public void setDaytrade_count(Integer daytrade_count) {
        this.daytrade_count = daytrade_count;
    }
}
