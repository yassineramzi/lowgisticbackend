package com.lowgistic.missionResponse.repository;

import com.lowgistic.missionResponse.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepositroy extends JpaRepository<Mission, Long> {
}
