package com.lowgistic.management.service.impl;

import com.lowgistic.management.domain.Role;
import com.lowgistic.management.domain.Utilisateur;
import com.lowgistic.management.enums.ERole;
import com.lowgistic.management.helper.PasswordGenrator;
import com.lowgistic.management.repository.RoleRepository;
import com.lowgistic.management.repository.UtilisateurRepository;
import com.lowgistic.management.sender.Sender;
import com.lowgistic.management.service.UtilisateurService;
import com.lowgistic.management.service.dto.RoleDto;
import com.lowgistic.management.service.dto.UtilisateurDto;
import com.lowgistic.management.service.mapper.UtilisateurMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    private final Logger log = LoggerFactory.getLogger(UtilisateurServiceImpl.class);

    private final UtilisateurRepository utilisateurRepository;

    private final RoleRepository roleRepository;

    private final UtilisateurMapper utilisateurMapper;

    private final PasswordEncoder passwordEncoder;

    private final Sender emailSender;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, RoleRepository roleRepository, UtilisateurMapper utilisateurMapper, PasswordEncoder passwordEncoder, Sender emailSender) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
        this.utilisateurMapper = utilisateurMapper;
        this.passwordEncoder = passwordEncoder;
        this.emailSender = emailSender;
    }

    @Override
    public UtilisateurDto create(UtilisateurDto utilisateurDto) throws Exception {
        log.info("Request to save Utilisateur : {}", utilisateurDto);
        if(this.utilisateurRepository.existsByEmail(utilisateurDto.getEmail())){
            throw new Exception("Utilisateur existe dèjà avec cet email : "+utilisateurDto.getEmail());
        }
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDto);
        // Set password
        String password = PasswordGenrator.generatePassword();
        utilisateur.setPassword(this.passwordEncoder.encode(password));
        // Set role
        Set<Role> roles = new HashSet<>();
        utilisateurDto.getRoles().add(new RoleDto(ERole.ROLE_ADMIN));
        utilisateurDto.getRoles().parallelStream().forEach(
                roleDTO -> {
                    Optional<Role> optionalRole = this.roleRepository.findByNomRole(roleDTO.getNomRole());
                    optionalRole.ifPresent(roles::add);
                }
        );
        utilisateur.setRoles(roles);
        // Save utilisateur
        utilisateur = utilisateurRepository.save(utilisateur);
        // Send mail
        UtilisateurDto returnedUtilisateur = utilisateurMapper.toDto(utilisateur);
        returnedUtilisateur.setPassword(password);
        this.emailSender.send("USER_REGISTERED_TOPIC", returnedUtilisateur);
        return returnedUtilisateur;
    }
}
