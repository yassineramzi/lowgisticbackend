package com.lowgistic.missionResponse.repository;

import com.lowgistic.missionResponse.domain.MissionResponse;
import com.lowgistic.missionResponse.enums.EStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionResponseRepositroy extends JpaRepository<MissionResponse, Long> {
    List<MissionResponse> findByMissionIdAndStatus(Long missionId, EStatus status);
}
