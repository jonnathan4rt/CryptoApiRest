package com.newpiece.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CryptocurrencyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String symbol;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "cap_maker", precision = 10, scale = 2)
    private BigDecimal capMaker;

    @Column(precision = 10, scale = 2)
    private BigDecimal volume;

    @ManyToOne
    @JoinColumn(name = "id_exchange", nullable = false)
    @JsonIgnore
    private ExchangeEntity exchangeEntity;

}
