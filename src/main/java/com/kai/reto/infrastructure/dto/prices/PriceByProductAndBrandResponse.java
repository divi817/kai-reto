package com.kai.reto.infrastructure.dto.prices;

import com.kai.common.infrastructure.dto.Dto;
import lombok.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class PriceByProductAndBrandResponse extends Dto {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
    private int productId;
    private int brandId;
    private int priceList;
    private String startDate;
    private String endDate;
    private double price;

    private void setDatesToString(LocalDateTime startLocalDate, LocalDateTime endLocalDate){
        this.startDate = dateFormat.format(startLocalDate);
        this.endDate = dateFormat.format(endLocalDate);
    }
}
