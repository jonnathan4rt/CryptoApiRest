package com.newpiece.rest.persistence;

import com.newpiece.rest.entities.CryptocurrencyEntity;

import java.util.List;
import java.util.Optional;

public interface ICryptocurrencyDAO {

    List<CryptocurrencyEntity> findAll();

    Optional<CryptocurrencyEntity> findById(Long id);

    void save(CryptocurrencyEntity cryptocurrencyEntity);

    void deleteById(Long id);
}
