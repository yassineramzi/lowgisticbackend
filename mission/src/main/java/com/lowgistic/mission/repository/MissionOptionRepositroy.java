package com.lowgistic.mission.repository;

import com.lowgistic.mission.domain.MissionOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionOptionRepositroy extends JpaRepository<MissionOption, Long> {
}
