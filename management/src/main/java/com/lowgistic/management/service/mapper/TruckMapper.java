package com.lowgistic.management.service.mapper;

import com.lowgistic.management.domain.Truck;
import com.lowgistic.management.service.dto.TruckDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TruckMapper extends EntityMapper<TruckDto, Truck>{
    @Override
    TruckDto toDto(Truck truck);

    @Override
    Truck toEntity(TruckDto truckDTO);

    default Truck fromId(Long id) {
        if (id == null) {
            return null;
        }
        Truck truck = new Truck();
        truck.setId(id);
        return truck;
    }
}
