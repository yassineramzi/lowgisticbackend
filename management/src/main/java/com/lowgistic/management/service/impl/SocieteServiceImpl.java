package com.lowgistic.management.service.impl;

import com.lowgistic.management.domain.Societe;
import com.lowgistic.management.repository.SocieteRepository;
import com.lowgistic.management.service.SocieteService;
import com.lowgistic.management.service.TenantService;
import com.lowgistic.management.service.dto.SocieteDto;
import com.lowgistic.management.service.mapper.SocieteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SocieteServiceImpl implements SocieteService {

    private final SocieteRepository societeRepository;

    private final SocieteMapper societeMapper;

    private final TenantService tenantService;

    @Override
    public SocieteDto create(SocieteDto societeDto) {
        Societe societe = this.societeMapper.toEntity(societeDto);
        societe = this.societeRepository.save(societe);
        this.tenantService.createTenant(societe);
        return this.societeMapper.toDto(societe);
    }
}
