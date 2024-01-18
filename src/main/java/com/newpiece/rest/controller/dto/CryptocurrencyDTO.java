package com.newpiece.rest.controller.dto;

import com.newpiece.rest.entities.ExchangeEntity;
import jakarta.validation.constraints.NotNull;
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

    private ExchangeEntity exchangeEntity;


}
