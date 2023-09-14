package com.lowgistic.gateway.repository;

import com.lowgistic.gateway.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the {@link User } entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value="select distinct u from User u " +
            "LEFT JOIN FETCH u.roles "+
            "where u.email = :email and u.password = :password")
    Optional<User> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query(value="select distinct u from User u " +
            "LEFT JOIN FETCH u.roles "+
            "where u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

}