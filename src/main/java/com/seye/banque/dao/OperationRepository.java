package com.seye.banque.dao;

import com.seye.banque.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query("select o from Operation o where o.compte.codeCompte=:x order by o.dateOperation desc")
    Page<Operation> listeOperations(@Param("x") String codeCpte, Pageable pageable);
}
