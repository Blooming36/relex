package com.javaRelex.mapper;

import com.javaRelex.dto.CollectingProductStatisticDto;
import com.javaRelex.entity.CollectingProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CollectingProductStatisticMapper {
    @Mapping(source = "product.name", target = "name")
    @Mapping(source = "product.unitOfMeasurement", target = "unitOfMeasurement")
    @Mapping(source = "userInfo.firstName", target = "firstName")
    @Mapping(source = "userInfo.lastName", target = "lastName")
    @Mapping(source = "userInfo.patronymic", target = "patronymic")
    CollectingProductStatisticDto toDTO(CollectingProduct collectingProduct);
}
