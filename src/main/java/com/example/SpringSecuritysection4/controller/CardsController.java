package com.example.SpringSecuritysection4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/myCards")
    public String getCardsDetails()
    {
        return "Here are cards details from DB";
    }
}
