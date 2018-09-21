package com.seye.banque.dao;

import com.seye.banque.entities.Retrait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RetaitRepository extends JpaRepository<Retrait, Long> {
}
