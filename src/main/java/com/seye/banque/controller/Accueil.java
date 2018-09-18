package com.seye.banque.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Accueil {
    @RequestMapping("/")
    public String accueil(){
        return "Accueil...";
    }
}
