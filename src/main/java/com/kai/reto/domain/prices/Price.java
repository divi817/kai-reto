package com.kai.reto.domain.prices;

import com.kai.common.domain.AggregateRoot;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Price extends AggregateRoot {
    private Long id;
    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private int productId;
    private int priority;
    private double price;
    private String currency;
}
