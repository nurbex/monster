package com.trading.monster.controllers;

import com.trading.monster.services.AlpacaAccountService;
import com.trading.monster.services.AlpacaAssetService;
import com.trading.monster.services.CalendarService;
import com.trading.monster.services.HistoricalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    CalendarService calendarService;

    @Autowired
    AlpacaAccountService alpacaAccountService;

    @Autowired
    AlpacaAssetService alpacaAssetService;

    @Autowired
    HistoricalDataService historicalDataService;

    @GetMapping
    public String getHomePage(){
        //calendarService.getAlpacaCalendar();
        //alpacaAccountService.getAlpacaAccount();
        //alpacaAssetService.getAssets();

        System.out.println(LocalDateTime.parse("2021-07-08T08:30:00"));
        historicalDataService.getOneMinBars(LocalDate.parse("2021-07-01"));

        return "home_page";
    }
}
