package com.newpiece.rest.controller.dto;

import com.newpiece.rest.entities.CryptocurrencyEntity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeDTO {

    private Long id;
    @NotBlank
    @Size(max = 50)
    private  String name;
    @NotBlank
    @Size(max = 50)
    private String location;
    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "10000.0000000")
    private BigDecimal numCrypto;
    @Min(value = 0)
    private int baseUser;


    private List<CryptocurrencyEntity> cryptocurrencyEntityList;

}
