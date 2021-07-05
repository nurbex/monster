package com.trading.monster.controllers;

import com.trading.monster.services.AlpacaAccountService;
import com.trading.monster.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    CalendarService calendarService;

    @Autowired
    AlpacaAccountService alpacaAccountService;

    @GetMapping
    public String getHomePage(){
        //calendarService.getAlpacaCalendar();
        alpacaAccountService.getAlpacaAccount();
        return "home_page";
    }
}
