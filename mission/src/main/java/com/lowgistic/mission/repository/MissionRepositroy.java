package com.lowgistic.mission.repository;

import com.lowgistic.mission.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepositroy extends JpaRepository<Mission, Long>, JpaSpecificationExecutor<Mission> {
}
