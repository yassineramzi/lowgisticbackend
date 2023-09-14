package com.lowgistic.management.service.mapper;

import com.lowgistic.management.domain.Warehouse;
import com.lowgistic.management.service.dto.WarehouseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WarehouseMapper extends EntityMapper<WarehouseDto, Warehouse>{
    @Override
    WarehouseDto toDto(Warehouse warehouse);

    @Override
    Warehouse toEntity(WarehouseDto warehouseDTO);

    default Warehouse fromId(Long id) {
        if (id == null) {
            return null;
        }
        Warehouse warehouse = new Warehouse();
        warehouse.setId(id);
        return warehouse;
    }
}
