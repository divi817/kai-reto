package com.kai.reto.infrastructure.rest;

import com.kai.reto.application.prices.PricesApplicationService;
import com.kai.reto.application.prices.query.GetPriceByProductAndBrandQuery;
import com.kai.reto.domain.prices.Price;
import com.kai.reto.infrastructure.dto.prices.PriceByProductAndBrandResponse;
import com.kai.reto.infrastructure.dto.prices.mappers.PricesMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
@Slf4j
public class PricesController {

    private final PricesApplicationService pricesApplicationService;

    private final PricesMapper pricesMapper;

    @GetMapping("")
    public ResponseEntity<PriceByProductAndBrandResponse> getPriceByBrandAndProduct(
            @RequestParam LocalDateTime date,
            @RequestParam(name = "product_id") int productId,
            @RequestParam(name = "brand_id") int brandId
    ) {
        log.info("PricesController#Get price by product and brand ".concat(String.valueOf(productId)));
        Price price = pricesApplicationService.getPriceByProductAndBrand(
                GetPriceByProductAndBrandQuery
                        .builder()
                        .startDate(date)
                        .brandId(brandId)
                        .productId(productId)
                        .build());
        return new ResponseEntity<>(pricesMapper.pricesEntityToPriceByProductAndBrandResponse(price), HttpStatus.OK);
    }
}
