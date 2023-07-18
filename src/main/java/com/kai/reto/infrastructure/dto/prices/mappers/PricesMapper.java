package com.kai.reto.infrastructure.dto.prices.mappers;

import com.kai.reto.domain.prices.Price;
import com.kai.reto.infrastructure.dto.prices.PriceByProductAndBrandResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricesMapper {
    @Mapping(target = "startDate", source = "startDate", dateFormat = "yyyy-MM-dd-HH:mm:ss")
    @Mapping(target = "endDate", source = "endDate", dateFormat = "yyyy-MM-dd-HH:mm:ss")
    PriceByProductAndBrandResponse pricesEntityToPriceByProductAndBrandResponse(Price prices);
}
