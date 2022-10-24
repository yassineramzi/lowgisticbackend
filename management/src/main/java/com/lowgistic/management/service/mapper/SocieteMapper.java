package com.lowgistic.management.service.mapper;

import com.lowgistic.management.domain.Societe;
import com.lowgistic.management.service.dto.SocieteDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class})
public interface SocieteMapper extends EntityMapper<SocieteDto, Societe>{
    @Override
    SocieteDto toDto(Societe Societe);

    @Override
    Societe toEntity(SocieteDto SocieteDTO);

    default Societe fromId(Long id) {
        if (id == null) {
            return null;
        }
        Societe Societe = new Societe();
        Societe.setId(id);
        return Societe;
    }
}
