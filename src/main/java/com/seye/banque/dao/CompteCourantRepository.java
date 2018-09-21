package com.seye.banque.dao;

import com.seye.banque.entities.CompteCourant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompteCourantRepository extends JpaRepository<CompteCourant, String> {
}
