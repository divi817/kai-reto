package com.kai.reto.domain.prices;

import com.kai.reto.domain.prices.mappers.PriceMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PricesService {

    private final PriceRepository priceRepository;

    private final PriceMapper priceMapper;

    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public Price getPriceByProductAndBrand(LocalDateTime date, int productId, int brandId) {
        String formatted_date = date.format(dateFormat);
        Optional<List<PriceEntity>> prices = priceRepository.getPriceByProductAndBrand(formatted_date, productId, brandId);
        if (prices.isPresent()) {
            Optional<PriceEntity> price = getMaxPriorityPrice(prices.get());
            if (price.isPresent()) {
                return priceMapper.priceEntityToPrice(price.get());
            }
        }
        return null;
    }

    public Optional<PriceEntity> getMaxPriorityPrice(List<PriceEntity> prices) {
        return prices
                .stream()
                .max(Comparator.comparing(PriceEntity::getPriority));
    }

}
