package com.lowgistic.missionResponse.web.resources;

import com.lowgistic.missionResponse.exception.CompanyNotFoundException;
import com.lowgistic.missionResponse.service.MissionResponseService;
import com.lowgistic.missionResponse.service.dto.MissionResponseDto;
import com.lowgistic.missionResponse.service.dto.MissionResponseOptionDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class MissionResponseApi {
    private final Logger log = LoggerFactory.getLogger(MissionResponseApi.class);

    private final MissionResponseService missionResponseService;

    @PostMapping("/create")
    public MissionResponseDto createMission(@RequestBody final MissionResponseDto missionResponseDto, @RequestHeader("X-COMPANY-ID") String companyId) throws CompanyNotFoundException {
        log.info("Create mission response : {},  for company : {} ", missionResponseDto, companyId);
        return missionResponseService.create(missionResponseDto, Long.parseLong(companyId));
    }

    @PutMapping("/update")
    public MissionResponseDto updateMission(@RequestBody final MissionResponseDto missionResponseDto, @RequestHeader("X-COMPANY-ID") String companyId) throws CompanyNotFoundException {
        log.info("Update mission response : {},  for company : {} ", missionResponseDto, companyId);
        return missionResponseService.update(missionResponseDto, Long.parseLong(companyId));
    }

    @GetMapping("/{idMission}/mission")
    public List<MissionResponseDto> searchMissionsForBuyer(@PathVariable("idMission") Long missionId, @RequestHeader("X-COMPANY-ID") String companyId) {
        log.info("Search for mission's responses for mission : {} and company : {}", missionId, companyId);
        return this.missionResponseService.findByMissionIdAndCompanyId(missionId, Long.parseLong(companyId));
    }

    @GetMapping("/by-company")
    public List<MissionResponseDto> searchMissionResponsesSubmittedByCompany(@RequestHeader("X-COMPANY-ID") String companyId) {
        log.info("Search for mission's responses submitted by company  : {}", companyId);
        return this.missionResponseService.findSubmittedByCompany(Long.parseLong(companyId));
    }
}
