package com.lowgistic.management.web.resources;

import com.lowgistic.management.service.SocieteService;
import com.lowgistic.management.service.UtilisateurService;
import com.lowgistic.management.service.dto.SocieteDto;
import com.lowgistic.management.service.dto.UtilisateurDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class ManagementApi {
    private final Logger log = LoggerFactory.getLogger(ManagementApi.class);

    private SocieteService societeService;

    private UtilisateurService utilisateurService;

    @PostMapping("/societe/create")
    public SocieteDto createSociete(@RequestBody final SocieteDto societeDto) {
        log.info("Création de la société {} ", societeDto);
        return societeService.create (societeDto);
    }

    @PostMapping("/societe/admin/create")
    public UtilisateurDto createAdminSociete(@RequestBody final UtilisateurDto utilisateurDto) throws Exception {
        log.info("Création de l'administrateur {} de la société {} ", utilisateurDto, utilisateurDto.getSociete());
        return utilisateurService.create(utilisateurDto);
    }
}
