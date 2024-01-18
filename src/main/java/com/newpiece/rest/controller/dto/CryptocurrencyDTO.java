package com.newpiece.rest.controller.dto;

import com.newpiece.rest.entities.ExchangeEntity;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CryptocurrencyDTO {

    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String symbol;
    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "10000.0000000")
    private BigDecimal price;
    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "10000.0000000")
    private BigDecimal capMaker;
    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "21000000.0")
    private BigDecimal volume;

    private ExchangeEntity exchangeEntity;


}
