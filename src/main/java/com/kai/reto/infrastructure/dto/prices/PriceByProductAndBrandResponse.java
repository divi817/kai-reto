package com.kai.reto.infrastructure.dto.prices;

import com.kai.common.infrastructure.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class PriceByProductAndBrandResponse extends Dto {
    private int productId;
    private int brandId;
    private int priceList;
    private String startDate;
    private String endDate;
    private double price;
}
