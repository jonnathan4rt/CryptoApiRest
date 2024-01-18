package com.newpiece.rest.controller.dto;

import com.newpiece.rest.entities.CryptocurrencyEntity;
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

    private  String name;

    private String location;


    private BigDecimal numCrypto;


    private int baseUser;


    private List<CryptocurrencyEntity> cryptocurrencyEntityList;

}
