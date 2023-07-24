package com.kai.reto.domain.prices.mappers;

import com.kai.reto.domain.prices.Price;
import com.kai.reto.domain.prices.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    Price priceEntityToPrice(PriceEntity prices);
    PriceEntity priceToPriceEntity(Price prices);
}

