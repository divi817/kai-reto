package com.kai.reto.domain.prices;

import com.kai.reto.domain.prices.mappers.PriceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PricesService {

    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public Price getPriceByProductAndBrand(LocalDateTime date, int productId, int brandId){
        Optional<List<PriceEntity>> prices = priceRepository.getPriceByProductAndBrand(date.format(dateFormat), productId,brandId);
        if(prices.isPresent()){
            Optional<PriceEntity> price = getMaxPriorityPrice(prices.get());
            if (price.isPresent()){
                return price.get();
            }
        }
        return null;
    }

    private Optional<PriceEntity> getMaxPriorityPrice(List<PriceEntity> prices){
        return prices
                .stream()
                .max(Comparator.comparing(Price::getPriority));
    }

}
