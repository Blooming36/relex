package com.javatechie.mapper;

import com.javatechie.dto.CollectingProductDto;
import com.javatechie.entity.CollectingProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CollectingProductMapper {
    @Mapping(source = "product.name", target = "name")
    @Mapping(source = "product.unitOfMeasurement", target = "unitOfMeasurement")
    CollectingProductDto toDTO(CollectingProduct collectingProduct);
}
