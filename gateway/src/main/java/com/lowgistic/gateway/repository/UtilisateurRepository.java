package com.lowgistic.gateway.repository;

import com.lowgistic.gateway.domain.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the {@link Utilisateur } entity.
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    @Query(value="select distinct u from Utilisateur u " +
            "LEFT JOIN FETCH u.roles "+
            "where u.email = :email and u.password = :password")
    Optional<Utilisateur> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query(value="select distinct u from Utilisateur u " +
            "LEFT JOIN FETCH u.roles "+
            "where u.email = :email")
    Optional<Utilisateur> findByEmail(@Param("email") String email);

}