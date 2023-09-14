package com.lowgistic.management.service.mapper;

import com.lowgistic.management.domain.User;
import com.lowgistic.management.service.dto.UserDto;
import org.apache.commons.lang.WordUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Mapper for the entity {@link User} and its DTO {@link UserDto}.
 */
@Mapper(componentModel = "spring", uses = {SocieteMapper.class})
public interface UserMapper extends EntityMapper<UserDto, User> {

    @Override
    UserDto toDto(User utilisateur);

    @Override
    User toEntity(UserDto userDTO);

    @AfterMapping
    default void before(UserDto userDTO, @MappingTarget User utilisateur) {
        utilisateur.setNom(WordUtils.capitalize(userDTO.getNom().toLowerCase()));
        utilisateur.setPrenom(WordUtils.capitalize(userDTO.getPrenom().toLowerCase()));
        utilisateur.setEmail(userDTO.getEmail().toLowerCase());
    }

    default User fromId(Long id) {
        if (id == null) {
            return null;
        }
        User utilisateur = new User();
        utilisateur.setId(id);
        return utilisateur;
    }
}
