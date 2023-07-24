package com.kai.reto.application;

import com.kai.common.infrastructure.exceptions.ApplicationException;
import com.kai.reto.application.prices.PricesApplicationService;
import com.kai.reto.application.prices.query.GetPriceByProductAndBrandQuery;
import com.kai.reto.domain.prices.PricesService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class PricesApplicationTests {

    @Mock
    private PricesService pricesService;
    @InjectMocks
    private PricesApplicationService pricesApplicationService;

    @Test
    void givenNullObjectShouldThrowException() {
        when(pricesService.getPriceByProductAndBrand(LocalDateTime.of(2020, 10, 10, 10, 10, 10), 1, 1)).thenReturn(null);
        assertThrows(ApplicationException.class, () -> pricesApplicationService.getPriceByProductAndBrand(
                GetPriceByProductAndBrandQuery
                        .builder()
                        .startDate(LocalDateTime.of(2020, 10, 10, 10, 10, 10))
                        .productId(1)
                        .brandId(1)
                        .build())
        );
    }
}
