package com.newpiece.rest.persistence;

import com.newpiece.rest.entities.Exchange;

import java.util.List;
import java.util.Optional;

public interface IExchangeDAO {

    List<Exchange> findAll();

    Optional<Exchange> findById(Long id);

    void save(Exchange exchange);

    void deleteById(Long id);
}
