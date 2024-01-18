package com.newpiece.rest.persistence;

import com.newpiece.rest.entities.ExchangeEntity;

import java.util.List;
import java.util.Optional;

public interface IExchangeDAO {

    List<ExchangeEntity> findAll();

    Optional<ExchangeEntity> findById(Long id);

    void save(ExchangeEntity exchangeEntity);

    void deleteById(Long id);
}
