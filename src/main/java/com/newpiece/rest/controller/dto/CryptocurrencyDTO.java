package com.newpiece.rest.controller.dto;

import com.newpiece.rest.entities.Exchange;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CryptocurrencyDTO {

    private Long id;

    private String name;

    private String symbol;

    private BigDecimal price;

    private BigDecimal capMaker;

    private BigDecimal volume;

    private Exchange exchange;


}
