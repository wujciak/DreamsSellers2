package com.ism.dreamssellersv2.mapper;

import com.ism.dreamssellersv2.model.ItemEntity;
import com.ism.model.ItemCreateDTO;
import com.ism.model.ItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    // ItemEntity -> ItemDTO
    @Mapping(source = "vendor.vendorId", target = "vendorId")
    ItemDTO itemEntityToItemDTO(ItemEntity itemEntity);

    // ItemCreateDTO -> ItemEntity
    @Mapping(target = "vendor.vendorId", source = "vendorId")
    ItemEntity itemCreateDTOToItemEntity(ItemCreateDTO itemCreateDTO);
}