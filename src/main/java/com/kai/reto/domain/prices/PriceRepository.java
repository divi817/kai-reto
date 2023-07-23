package com.kai.reto.domain.prices;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {
    @Query(value = "SELECT * FROM prices " +
            "WHERE brand_id = :brandId " +
            "AND product_id = :productId " +
            "AND :date BETWEEN start_date AND end_date ",
            nativeQuery = true)
    Optional<List<Price>> getPriceByProductAndBrand(String date, int productId, int brandId);
}
