package com.kai.reto.application.prices.query;

import com.kai.common.application.querybus.Query;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Builder
@Getter
@Setter
public class GetPriceByProductAndBrandQuery extends Query {
    private int productId;
    private int brandId;
    private LocalDateTime startDate;
}
