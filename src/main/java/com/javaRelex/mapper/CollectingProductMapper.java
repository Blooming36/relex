package com.javaRelex.mapper;

import com.javaRelex.dto.CollectingProductDto;
import com.javaRelex.entity.CollectingProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CollectingProductMapper {
    @Mapping(source = "product.name", target = "name")
    @Mapping(source = "product.unitOfMeasurement", target = "unitOfMeasurement")
    CollectingProductDto toDTO(CollectingProduct collectingProduct);
}
