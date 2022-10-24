package com.lowgistic.management.service.mapper;

import com.lowgistic.management.domain.Utilisateur;
import com.lowgistic.management.service.dto.UtilisateurDto;
import org.apache.commons.lang.WordUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Mapper for the entity {@link Utilisateur} and its DTO {@link UtilisateurDto}.
 */
@Mapper(componentModel = "spring", uses = {SocieteMapper.class})
public interface UtilisateurMapper extends EntityMapper<UtilisateurDto, Utilisateur> {

    @Override
    UtilisateurDto toDto(Utilisateur utilisateur);

    @Override
    Utilisateur toEntity(UtilisateurDto utilisateurDTO);

    @AfterMapping
    default void before(UtilisateurDto utilisateurDTO, @MappingTarget Utilisateur utilisateur) {
        utilisateur.setNom(WordUtils.capitalize(utilisateurDTO.getNom().toLowerCase()));
        utilisateur.setPrenom(WordUtils.capitalize(utilisateurDTO.getPrenom().toLowerCase()));
        utilisateur.setLogin(utilisateurDTO.getLogin().toLowerCase());
        utilisateur.setEmail(utilisateurDTO.getEmail().toLowerCase());
    }

    default Utilisateur fromId(Long id) {
        if (id == null) {
            return null;
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(id);
        return utilisateur;
    }
}
