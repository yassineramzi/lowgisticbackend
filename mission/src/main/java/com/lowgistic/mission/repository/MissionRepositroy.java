package com.lowgistic.mission.repository;

import com.lowgistic.mission.domain.Mission;
import com.lowgistic.mission.enums.EStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRepositroy extends JpaRepository<Mission, Long>, JpaSpecificationExecutor<Mission> {
    List<Mission> findByCompanyId(Long companyId);

    List<Mission> findByCompanyIdNotAndStatus(Long companyId, EStatus status);
}
