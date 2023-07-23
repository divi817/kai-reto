package com.kai.reto.domain;

import com.kai.reto.domain.prices.Price;
import com.kai.reto.domain.prices.PriceRepository;
import com.kai.reto.domain.prices.PricesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PricesServiceTests {
    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PricesService pricesService;

    Price priceWithHighPriority = new Price(Long.parseLong("1"), 1, LocalDateTime.of(2020, 10, 10, 10, 10, 10), LocalDateTime.of(2021, 10, 10, 10, 10, 10), 1, 1, 1, 50, "EUR");
    Price priceWithLowPriority = new Price(Long.parseLong("1"), 1, LocalDateTime.of(2020, 10, 10, 10, 10, 10), LocalDateTime.of(2021, 10, 10, 10, 10, 10), 1, 1, 1, 50, "EUR");


    @Test
    void givenPricesListShouldReturnMaxPriorityPrice() {

        List<Price> pricesListWithDifferentPrority = new ArrayList<>();
        pricesListWithDifferentPrority.add(priceWithHighPriority);
        pricesListWithDifferentPrority.add(priceWithLowPriority);
        when(priceRepository.getPriceByProductAndBrand(anyString(), anyInt(), anyInt())).thenReturn(Optional.of(pricesListWithDifferentPrority));

        Price price = pricesService.getPriceByProductAndBrand(LocalDateTime.of(2020, 10, 10, 10, 10, 10), 1, 1);
        assertEquals(price, priceWithLowPriority);
    }

    @Test
    void givenEmptyListShouldReturnNull() {
        when(priceRepository.getPriceByProductAndBrand(anyString(), anyInt(), anyInt())).thenReturn(Optional.of(null));
        Price price = pricesService.getPriceByProductAndBrand(LocalDateTime.of(2020, 10, 10, 10, 10, 10), 1, 1);
        assertEquals(price, null);
    }
}
