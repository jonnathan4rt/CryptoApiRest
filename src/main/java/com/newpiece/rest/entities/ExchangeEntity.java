package com.newpiece.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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

    @NotBlank
    @Size(max = 80)
    private  String name;
    @NotBlank
    @Size(max = 80)
    private String location;

    @Column(name = "num_crypto")
    private BigDecimal numCrypto;

    @Column(name = "base_user")
    private int baseUser;

    @OneToMany(mappedBy = "exchangeEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    private List<CryptocurrencyEntity> cryptocurrencyEntityList = new ArrayList<>();
}