package com.lowgistic.management.repository;

import com.lowgistic.management.domain.Utilisateur;
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
            "where u.login = :login and u.password = :password")
    Optional<Utilisateur> findByLoginAndPassword(@Param("login") String login, @Param("password") String password);

    Boolean existsByLoginOrEmail(String login, String email);

    @Query(value="select CASE WHEN COUNT(u) > 0 THEN true ELSE false END from Utilisateur u "+
            "where (u.login = :login and u.id <> :id) " +
            "or (u.email = :email and u.id <> :id)")
    Boolean existsByLoginAndIdOrEmailAndId(@Param("login") String login, @Param("email") String email, @Param("id") Long id);
}
