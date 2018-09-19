package com.seye.banque.controller;

import com.seye.banque.entities.Compte;
import com.seye.banque.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BanqueController {
    @Autowired
    private IBanqueMetier banqueMetier;

    @RequestMapping("/operations")
    public String index(){
        return null;
    }

    public String consulter(Model model, String codeCompte){
        try {
            Compte compte=banqueMetier.consulterCompte(codeCompte);
            model.addAttribute("compte",codeCompte);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
        return null;
    }
}
