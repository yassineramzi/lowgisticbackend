package com.lowgistic.management.repository;

import com.lowgistic.management.domain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the {@link Utilisateur } entity.
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Boolean existsByEmail(String email);

}
