package com.lowgistic.management.repository;

import com.lowgistic.management.domain.EmailToBeSent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the {@link EmailToBeSent } entity.
 */
@Repository
public interface EmailToBeSentRepository extends JpaRepository<EmailToBeSent, Long> {
}
