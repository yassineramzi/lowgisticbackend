package com.lowgistic.management.repository;

import com.lowgistic.management.domain.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteRepository extends JpaRepository<Societe, Long>{
}
