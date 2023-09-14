package com.lowgistic.mission.repository;

import com.lowgistic.mission.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepositroy extends JpaRepository<Country, Long> {
    List<Country> findByNameContainingIgnoreCase(String name);
}
