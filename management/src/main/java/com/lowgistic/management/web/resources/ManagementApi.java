package com.lowgistic.management.web.resources;

import com.lowgistic.management.service.CompanyService;
import com.lowgistic.management.service.UserService;
import com.lowgistic.management.service.dto.CompanyDto;
import com.lowgistic.management.service.dto.CompanyInformationDto;
import com.lowgistic.management.service.dto.UserDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class ManagementApi {
    private final Logger log = LoggerFactory.getLogger(ManagementApi.class);

    private final UserService userService;

    private final CompanyService companyService;

    @PostMapping("/register")
    public UserDto createAdminSociete(@RequestBody final UserDto userDto) throws Exception {
        log.info("Register User  : {}", userDto);
        return userService.create(userDto);
    }

    @PostMapping("/company/add-information")
    public CompanyInformationDto addCompanyInformation(@RequestBody final CompanyInformationDto companyInformationDto, @RequestHeader("X-COMPANY-ID") String companyId) {
        log.info("Save Company information : {} for company : {}", companyInformationDto, companyId);
        return companyService.create(companyInformationDto, Long.parseLong(companyId));
    }

    @PutMapping("/company/update-information")
    public CompanyInformationDto updateCompanyInformation(@RequestBody final CompanyInformationDto companyInformationDto, @RequestHeader("X-COMPANY-ID") String companyId) {
        log.info("Update Company information : {} for company : {}", companyInformationDto, companyId);
        return companyService.update(companyInformationDto, Long.parseLong(companyId));
    }

    @GetMapping("/company/company-information")
    public CompanyInformationDto getCompanyInformation(@RequestHeader("X-COMPANY-ID") String companyId) {
        log.info("Find Company information for company : {}", companyId);
        return companyService.findCompanyInformationByCompanyId(Long.parseLong(companyId));
    }

    @GetMapping("/my-company")
    public CompanyDto getMyCompany(@RequestHeader("X-COMPANY-ID") String companyId) {
        log.info("Find my company : {}", companyId);
        return companyService.findByCompanyId(Long.parseLong(companyId));
    }

    @GetMapping("/{id}")
    public CompanyDto getCompanyById(@PathVariable("id") final Long companyId) {
        log.info("Find company by id : {}", companyId);
        return companyService.findByCompanyId(companyId);
    }
}
