package com.newpiece.rest.persistence;

import com.newpiece.rest.entities.Cryptocurrency;

import java.util.List;
import java.util.Optional;

public interface ICryptocurrencyDAO {

    List<Cryptocurrency> findAll();

    Optional<Cryptocurrency> findById(Long id);

    void save(Cryptocurrency cryptocurrency);

    void deleteById(Long id);
}
