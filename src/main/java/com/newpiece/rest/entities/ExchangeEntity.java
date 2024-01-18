package com.newpiece.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExchangeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private  String name;

    private String location;

    @Column(name = "num_crypto")
    private String numCrypto;

    @Column(name = "base_user")
    private int baseUser;

    @OneToMany(mappedBy = "exchangeEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<CryptocurrencyEntity> cryptocurrencyEntityList = new ArrayList<>();
}