package com.kai.reto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kai.reto.infrastructure.dto.prices.PriceByProductAndBrandResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PricesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void should_get_validation_error() throws Exception {
        mockMvc.perform(get("/prices")).andExpect(status().isBadRequest());
    }

    @Test
    void should_get_correct_price_information_case_1() throws Exception {
        PriceByProductAndBrandResponse expected_response = PriceByProductAndBrandResponse.builder()
                .brandId(1)
                .productId(35455)
                .price(35.50)
                .priceList(1)
                .startDate("2020-06-14-00:00:00")
                .endDate("2020-12-31-23:59:59")
                .build();

        LocalDateTime date = LocalDateTime.parse("2020-06-14T10:00");

        mockMvc.perform(get("/prices?brand_id=1&date=" + date.toString() + "&product_id=35455"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(expected_response.getProductId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(expected_response.getBrandId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(expected_response.getPrice()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(expected_response.getPriceList()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value(expected_response.getStartDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value(expected_response.getEndDate()));
    }

    @Test
    void should_get_correct_price_information_case_2() throws Exception {
        PriceByProductAndBrandResponse expected_response = PriceByProductAndBrandResponse.builder()
                .brandId(1)
                .productId(35455)
                .price(25.45)
                .priceList(2)
                .startDate("2020-06-14-15:00:00")
                .endDate("2020-06-14-18:30:00")
                .build();

        LocalDateTime date = LocalDateTime.parse("2020-06-14T16:00");


        mockMvc.perform(get("/prices?brand_id=1&date=" + date.toString() + "&product_id=35455"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(expected_response.getProductId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(expected_response.getBrandId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(expected_response.getPrice()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(expected_response.getPriceList()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value(expected_response.getStartDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value(expected_response.getEndDate()));
    }

    @Test
    void should_get_correct_price_information_case_3() throws Exception {
        PriceByProductAndBrandResponse expected_response = PriceByProductAndBrandResponse.builder()
                .brandId(1)
                .productId(35455)
                .price(35.50)
                .priceList(1)
                .startDate("2020-06-14-00:00:00")
                .endDate("2020-12-31-23:59:59")
                .build();

        LocalDateTime date = LocalDateTime.parse("2020-06-14T21:00");


        mockMvc.perform(get("/prices?brand_id=1&date=" + date.toString() + "&product_id=35455"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(expected_response.getProductId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(expected_response.getBrandId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(expected_response.getPrice()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(expected_response.getPriceList()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value(expected_response.getStartDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value(expected_response.getEndDate()));
    }

    @Test
    void should_get_correct_price_information_case_4() throws Exception {
        PriceByProductAndBrandResponse expected_response = PriceByProductAndBrandResponse.builder()
                .brandId(1)
                .productId(35455)
                .price(30.50)
                .priceList(3)
                .startDate("2020-06-15-00:00:00")
                .endDate("2020-06-15-11:00:00")
                .build();

        LocalDateTime date = LocalDateTime.parse("2020-06-15T10:00");

        mockMvc.perform(get("/prices?brand_id=1&date=" + date.toString() + "&product_id=35455"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(expected_response.getProductId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(expected_response.getBrandId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(expected_response.getPrice()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(expected_response.getPriceList()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value(expected_response.getStartDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value(expected_response.getEndDate()));
    }

    @Test
    void should_get_correct_price_information_case_5() throws Exception {
        PriceByProductAndBrandResponse expected_response = PriceByProductAndBrandResponse.builder()
                .brandId(1)
                .productId(35455)
                .price(38.95)
                .priceList(4)
                .startDate("2020-06-15-16:00:00")
                .endDate("2020-12-31-23:59:59")
                .build();

        LocalDateTime date = LocalDateTime.parse("2020-06-16T21:00");

        MvcResult result = mockMvc.perform(get("/prices?brand_id=1&date=" + date.toString() + "&product_id=35455"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.product_id").value(expected_response.getProductId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand_id").value(expected_response.getBrandId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(expected_response.getPrice()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price_list").value(expected_response.getPriceList()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.start_date").value(expected_response.getStartDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.end_date").value(expected_response.getEndDate()))
                .andReturn();
    }
}
