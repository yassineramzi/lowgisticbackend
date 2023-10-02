package com.lowgistic.mission.service.impl;

import com.lowgistic.mission.domain.Mission;
import com.lowgistic.mission.enums.EStatus;
import com.lowgistic.mission.service.dto.searchCriteria.MissionSearchCriteriaDto;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


public class MissionSpecifications {

    public static Specification<Mission> filterMissions(final MissionSearchCriteriaDto criteria, final Long companyId) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getFreightOrigin() != null) {
                predicates.add(criteriaBuilder.equal(root.get("freightFrom"), criteria.getFreightOrigin()));
            }

            if (criteria.getFreightDestination() != null) {
                predicates.add(criteriaBuilder.equal(root.get("freightTo"), criteria.getFreightDestination()));
            }

            if (criteria.getWarehouseCity() != null) {
                predicates.add(criteriaBuilder.equal(root.get("warehousingMissionCity"), criteria.getWarehouseCity()));
            }

            if (criteria.getMissionType() != null) {
                boolean isWarehouseMission = ("all".equalsIgnoreCase(criteria.getMissionType()) || "warehouse".equalsIgnoreCase(criteria.getMissionType()));
                boolean isFreightMission = ("all".equalsIgnoreCase(criteria.getMissionType()) || "freight".equalsIgnoreCase(criteria.getMissionType()));
                predicates.add(criteriaBuilder.equal(root.get("isWarehouseMission"), isWarehouseMission));
                predicates.add(criteriaBuilder.equal(root.get("isFreightMission"), isFreightMission));
            }
            // GET ONLY SUBMITTED MISSIONS
            predicates.add(criteriaBuilder.equal(root.get("status"), EStatus.SUBMITTED));
            // GET THE MISSIONS THAT DOESN'T BELONG TO THE SEARCHING COMPANY
            predicates.add(criteriaBuilder.notEqual(root.get("companyId"), companyId));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
