package com.javatechie.mapper;

import com.javatechie.dto.CollectingProductDto;
import com.javatechie.dto.CollectingProductStatisticDto;
import com.javatechie.entity.CollectingProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CollectingProductStatisticMapper {
    @Mapping(source = "product.name", target = "name")
    @Mapping(source = "product.unitOfMeasurement", target = "unitOfMeasurement")
    @Mapping(source = "UserInfo.firstName", target = "firstName")
    @Mapping(source = "UserInfo.lastName", target = "lastName")
    @Mapping(source = "UserInfo.patronymic", target = "patronymic")
    CollectingProductStatisticDto toDTO(CollectingProduct collectingProduct);
}
