package com.kai.reto.domain.prices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PricesService {

    private final PriceRepository priceRepository;

    public Price getPriceByProductAndBrand(LocalDateTime date, int productId, int brandId){
        Price price = priceRepository.getPriceByProductAndBrand(date, productId, brandId);
        return price;
    }

}
