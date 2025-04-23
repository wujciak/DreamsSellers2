package com.ism.dreamssellersv2.mapper;

import com.ism.dreamssellersv2.model.OrderEntity;
import com.ism.model.OrderDTO;
import com.ism.model.OrderCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ItemMapper.class})
public interface OrderMapper {

    // OrderEntity -> OrderDTO
    @Mapping(source = "user.userId", target = "userId")
    OrderDTO orderEntityToOrderDTO(OrderEntity orderEntity);

    // OrderCreateDTO -> OrderEntity
    @Mapping(target = "user.userId", source = "userId")
    @Mapping(target = "items", ignore = true)
    OrderEntity orderCreateDTOToOrderEntity(OrderCreateDTO orderCreateDTO);
}