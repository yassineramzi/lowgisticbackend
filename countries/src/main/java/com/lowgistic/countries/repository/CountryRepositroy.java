package com.lowgistic.countries.repository;

import com.lowgistic.countries.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepositroy extends JpaRepository<Country, Long> {
    List<Country> findByNameContainingIgnoreCase(String name);
}
