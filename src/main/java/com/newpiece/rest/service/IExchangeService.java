package com.newpiece.rest.service;

import com.newpiece.rest.entities.Exchange;

import java.util.List;
import java.util.Optional;

public interface IExchangeService {

    List<Exchange> findAll();

    Optional<Exchange> findById(Long id);

    void save(Exchange exchange);

    void deleteById(Long id);
}
