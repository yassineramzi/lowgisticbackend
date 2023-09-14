package com.lowgistic.management.repository;

import com.lowgistic.management.domain.CompanyInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyInformationRepository extends JpaRepository<CompanyInformation, Long>{
    Optional<CompanyInformation> findByCompanyId(Long companyId);
}
