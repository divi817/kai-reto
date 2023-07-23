package com.kai.reto.domain.prices;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PriceRepository extends CrudRepository<PriceEntity, Long> {
    @Query(value = "SELECT * FROM prices " +
            "WHERE brand_id = :brandId " +
            "AND product_id = :productId " +
            "AND :date BETWEEN start_date AND end_date " +
            "ORDER BY priority DESC " +
            "LIMIT 1",
            nativeQuery = true)
    PriceEntity getPriceByProductAndBrand(String date, int productId, int brandId);
}
