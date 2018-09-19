package com.seye.banque.metier;

import com.seye.banque.dao.CompteRepository;
import com.seye.banque.dao.OperationRepository;
import com.seye.banque.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Override
    public Compte consulterCompte(String codeCompte) {
        Compte cmpte=compteRepository.getOne(codeCompte);
        if (cmpte==null)
            throw new RuntimeException("Compte introuvable");
        return cmpte;
    }

    @Override
    public void verser(String codeCompte, double montant) {
        Compte compte = consulterCompte(codeCompte);
        Versement versement=new Versement(new Date(),montant,compte);
        operationRepository.save(versement);
        compte.setSolde(compte.getSolde()+montant);
        compteRepository.save(compte);
    }

    @Override
    public void retirer(String codeCompte, double montant) {
        Compte compte=consulterCompte(codeCompte);
        double rbt=0;
        if (compte instanceof CompteCourant)
            rbt=((CompteCourant) compte).getDecouvert();
        if (compte.getSolde()+rbt<montant)
            throw new RuntimeException("Solde insuffisant");
        Retrait retrait = new Retrait(new Date(),montant,compte);
        operationRepository.save(retrait);
        compte.setSolde(compte.getSolde()-montant);
        compteRepository.save(compte);
    }

    @Override
    public void virement(String codeCompte1, String codeCompte2, double montant) {
        retirer(codeCompte1,montant);
        verser(codeCompte2,montant);
    }

    @Override
    public Page<Operation> listeDesOperations(String codeCompte, int page, int size) {
        return operationRepository.listeOperations(codeCompte, new QPageRequest(page,size));
    }
}
