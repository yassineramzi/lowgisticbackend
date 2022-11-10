package com.lowgistic.management.web.resources;

import com.lowgistic.management.service.UtilisateurService;
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

    private UtilisateurService utilisateurService;

    @PostMapping("/register")
    public UtilisateurDto createAdminSociete(@RequestBody final UtilisateurDto utilisateurDto) throws Exception {
        log.info("Register User  : {}", utilisateurDto);
        return utilisateurService.create(utilisateurDto);
    }
}
