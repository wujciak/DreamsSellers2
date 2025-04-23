package com.ism.dreamssellersv2.mapper;

import com.ism.dreamssellersv2.model.VendorEntity;
import com.ism.model.VendorCreateDTO;
import com.ism.model.VendorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VendorMapper {

    // VendorEntity -> VendorDTO
    VendorDTO vendorEntityToVendorDTO(VendorEntity vendorEntity);

    // VendorCreateDTO -> VendorEntity
    @Mapping(target = "vendorId", ignore = true)
    VendorEntity vendorCreateDTOToVendorEntity(VendorCreateDTO vendorCreateDTO);
}