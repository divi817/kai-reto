package com.kai.reto.domain.prices;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceRepository extends PagingAndSortingRepository<Price, Long> {

    @Query(value = "SELECT * FROM price" +
            "WHERE brand_id = :brandId" +
            "AND product_id = :productId" +
            "AND :date BETWEEN start_date AND end_date" +
            "ORDER BY priority" +
            "LIMIT 1",
            nativeQuery = true)
    Price getPriceByProductAndBrand(LocalDateTime date, int brandId, int productId);
}
