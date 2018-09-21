package com.seye.banque.dao;

import com.seye.banque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, String> {
}
