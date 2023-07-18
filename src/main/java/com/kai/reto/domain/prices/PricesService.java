package com.kai.reto.domain.prices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class PricesService {

    private final PriceRepository priceRepository;

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public Price getPriceByProductAndBrand(LocalDateTime date, int productId, int brandId){
        Price price = priceRepository.getPriceByProductAndBrand(date.format(dateFormat), productId,brandId);
        return price;
    }

}
