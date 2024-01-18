package com.newpiece.rest.service;

import com.newpiece.rest.entities.ExchangeEntity;

import java.util.List;
import java.util.Optional;

public interface IExchangeService {

    List<ExchangeEntity> findAll();

    Optional<ExchangeEntity> findById(Long id);

    void save(ExchangeEntity exchangeEntity);

    void deleteById(Long id);
}
