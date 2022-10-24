package com.lowgistic.management.repository;

import com.lowgistic.management.domain.Role;
import com.lowgistic.management.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the {@link Role } entity.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByNomRole(ERole name);
}
