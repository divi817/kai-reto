package com.kai.reto.application.prices.query;

import com.kai.common.application.querybus.Query;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class GetPriceByProductAndBrandQuery extends Query {
    @NonNull
    private int productId;
    @NonNull
    private int brandId;
    @NonNull
    private LocalDateTime startDate;
}
