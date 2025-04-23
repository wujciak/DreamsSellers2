package com.ism.dreamssellersv2.mapper;

import com.ism.dreamssellersv2.model.ReviewEntity;
import com.ism.model.ReviewCreateDTO;
import com.ism.model.ReviewDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    // ReviewEntity -> ReviewDTO
    @Mapping(source = "item.itemId", target = "itemId")
    @Mapping(source = "user.userId", target = "userId")
    @Mapping(source = "user.name", target = "username")
    ReviewDTO reviewEntityToReviewDTO(ReviewEntity reviewEntity);

    // ReviewCreateDTO -> ReviewEntity
    @Mapping(target = "item.itemId", source = "itemId")
    @Mapping(target = "user.userId", source = "userId")
    ReviewEntity reviewCreateDTOToReviewEntity(ReviewCreateDTO reviewCreateDTO);
}