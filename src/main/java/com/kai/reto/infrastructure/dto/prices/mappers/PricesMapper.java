package com.kai.reto.infrastructure.dto.prices.mappers;

import com.kai.reto.domain.prices.Price;
import com.kai.reto.infrastructure.dto.prices.PriceByProductAndBrandResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesMapper {
    PriceByProductAndBrandResponse pricesEntityToPriceByProductAndBrandResponse(Price prices);
}
