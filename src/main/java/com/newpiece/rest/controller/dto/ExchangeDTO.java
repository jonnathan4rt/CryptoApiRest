package com.newpiece.rest.controller.dto;

import com.newpiece.rest.entities.Cryptocurrency;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class ExchangeDTO {

    private Long id;

    private  String name;

    private String location;


    private String numCrypto;


    private int baseUser;


    private List<Cryptocurrency> cryptocurrencyList;

}
