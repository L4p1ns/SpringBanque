package com.seye.banque.dao;

import com.seye.banque.entities.CompteEpargne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteEpargneRepository extends JpaRepository<CompteEpargne, String> {
}
