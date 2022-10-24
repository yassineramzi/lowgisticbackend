package com.lowgistic.gateway.service.mapper;

import com.lowgistic.gateway.service.dto.SocieteDto;
import com.thinline.crm.gateway.domain.Societe;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
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
