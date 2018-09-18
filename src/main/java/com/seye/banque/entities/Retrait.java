package com.seye.banque.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {
    public Retrait() {
        super();
    }

    public Retrait(Date dateOperation, Double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}