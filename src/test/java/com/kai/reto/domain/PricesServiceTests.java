package com.kai.reto.domain;

import com.kai.reto.domain.prices.Price;
import com.kai.reto.domain.prices.PriceRepository;
import com.kai.reto.domain.prices.PricesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class PricesServiceTests {
    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PricesService pricesService;

    protected final Price priceWithHighPriority = Price
            .builder()
            .id(Long.parseLong("2"))
            .brandId(1)
            .productId(1)
            .priority(4)
            .priceList(2)
            .startDate(LocalDateTime.of(2020, 10, 10, 10, 10, 10))
            .endDate(LocalDateTime.of(2021, 10, 10, 10, 10, 10))
            .price(1234)
            .currency("EUR")
            .build();
    protected final Price priceWithLowPriority = Price
            .builder()
            .id(Long.parseLong("1"))
            .brandId(1)
            .productId(1)
            .priority(2)
            .priceList(1)
            .startDate(LocalDateTime.of(2020, 10, 10, 10, 10, 10))
            .endDate(LocalDateTime.of(2021, 10, 10, 10, 10, 10))
            .price(50)
            .currency("EUR")
            .build();


    @Test
    void givenPricesListShouldReturnMaxPriorityPrice() {
        List<Price> prices = new ArrayList<>();
        prices.add(priceWithLowPriority);
        prices.add(priceWithHighPriority);
        Optional<List<Price>> pricesListWithDifferentPrority = Optional.of(prices);

        Mockito.when(priceRepository.getPriceByProductAndBrand(anyString(), anyInt(), anyInt())).thenReturn(pricesListWithDifferentPrority);
        Price price = pricesService.getPriceByProductAndBrand(LocalDateTime.of(2020, 10, 10, 10, 10, 10), 1, 1);

        assertEquals(price, priceWithHighPriority);
    }

    @Test
    void givenEmptyListServiceShouldReturnNull() {
        Price price = pricesService.getPriceByProductAndBrand(LocalDateTime.of(2020, 10, 10, 10, 10, 10), 1, 1);
        assert (Objects.isNull(price));
    }
}
