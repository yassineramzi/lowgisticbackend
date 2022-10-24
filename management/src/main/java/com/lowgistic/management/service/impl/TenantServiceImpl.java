package com.lowgistic.management.service.impl;

import com.lowgistic.management.domain.Societe;
import com.lowgistic.management.domain.Tenant;
import com.lowgistic.management.enums.EStatusTenant;
import com.lowgistic.management.repository.TenantRepository;
import com.lowgistic.management.service.TenantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TenantServiceImpl implements TenantService {

    private final TenantRepository tenantRepository;

    @Override
    public void createTenant(Societe societe) {
        Tenant tenant = new Tenant();
        tenant.setNom(societe.getNom().replaceAll("\\s+","") );
        tenant.setSociete(societe);
        tenant.setStatus(EStatusTenant.NOT_CREATED);
        this.tenantRepository.save(tenant);
    }
}
