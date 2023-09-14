package com.lowgistic.mission.web.resources;

import com.lowgistic.mission.service.MissionOptionService;
import com.lowgistic.mission.service.MissionService;
import com.lowgistic.mission.service.dto.MissionDto;
import com.lowgistic.mission.service.dto.MissionOptionDto;
import com.lowgistic.mission.service.dto.searchCriteria.MissionSearchCriteriaDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class MissionApi {
    private final Logger log = LoggerFactory.getLogger(MissionApi.class);

    private final MissionService missionService;

    private final MissionOptionService missionOptionService;

    @PostMapping("/create")
    public MissionDto createMission(@RequestBody final MissionDto missionDto, @RequestHeader("X-COMPANY-ID") String companyId) {
        log.info("Create mission : {} ", missionDto);
        missionDto.setCompanyId(Long.parseLong(companyId));
        return missionService.create(missionDto);
    }

    @PutMapping("/update")
    public MissionDto updateMission(@RequestBody final MissionDto missionDto, @RequestHeader("X-COMPANY-ID") String companyId) {
        log.info("Update mission : {} ", missionDto);
        missionDto.setCompanyId(Long.parseLong(companyId));
        return missionService.update(missionDto);
    }

    @GetMapping("/search-for-buyer")
    public List<MissionDto> searchMissionsForBuyer(@RequestHeader("X-COMPANY-ID") String companyId) {
        log.info("Search for company mission : {} ", companyId);
        return this.missionService.findByCompany(Long.parseLong(companyId));
    }

    @GetMapping("/{id}")
    public MissionDto findMissionById(@PathVariable("id") final Long idMission) {
        log.info("Get mission by Id : {} ", idMission);
        return missionService.findById(idMission);
    }

    @GetMapping("/mission-options")
    public List<MissionOptionDto> findAllMissionOptions() {
        log.info("Get all mission's options ");
        return missionOptionService.findAll();
    }

    @PostMapping("/search-for-seller")
    public List<MissionDto> searchMissionsForSeller(@RequestHeader("X-COMPANY-ID") String companyId) {
        log.info("Search for seller mission : {} ", companyId);
        return missionService.findAllForSeller(Long.parseLong(companyId));
    }
}
