package com.kai.reto.application.prices;

import com.kai.reto.application.prices.query.GetPriceByProductAndBrandQuery;
import com.kai.common.infrastructure.exceptions.ApplicationException;
import com.kai.reto.domain.prices.Price;
import com.kai.reto.domain.prices.PricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PricesApplicationService {

    private final PricesService pricesService;

    public Price getPriceByProductAndBrand(GetPriceByProductAndBrandQuery query) {
        Price price = pricesService.getPriceByProductAndBrand(query.getStartDate(), query.getProductId(), query.getBrandId());
        if (Objects.isNull(price)) {
            throw new ApplicationException("Price not found for this parameters");
        }
        return price;
    }

}
