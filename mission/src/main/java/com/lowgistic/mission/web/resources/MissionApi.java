package com.lowgistic.mission.web.resources;

import com.lowgistic.mission.service.MissionService;
import com.lowgistic.mission.service.dto.MissionDto;
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

    @PostMapping("/create")
    public MissionDto createMission(@RequestBody final MissionDto missionDto) {
        log.info("Create mission : {} ", missionDto);
        return missionService.create(missionDto);
    }

    @PutMapping("/update")
    public MissionDto updateMission(@RequestBody final MissionDto missionDto) {
        log.info("Update mission : {} ", missionDto);
        return missionService.update(missionDto);
    }

    @PostMapping("/search-for-buyer")
    public List<MissionDto> searchMissionsForBuyer(@RequestBody final MissionSearchCriteriaDto missionSearchCriteriaDto) {
        log.info("Mission search by criteria: {} ", missionSearchCriteriaDto);
        return this.missionService.findByCriteria(missionSearchCriteriaDto);
    }

    @GetMapping("/{id}")
    public MissionDto findMissionById(@PathVariable("id") final Long idMission) {
        log.info("Get mission by Id : {} ", idMission);
        return missionService.findById(idMission);
    }

}
