package com.newpiece.rest.persistence.impl;

import com.newpiece.rest.entities.Exchange;
import com.newpiece.rest.persistence.IExchangeDAO;
import com.newpiece.rest.repository.IExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ExchangeDAOImpl implements IExchangeDAO {
    @Autowired
    private IExchangeRepository exchangeRepository;
    @Override
    public List<Exchange> findAll() {
        return (List<Exchange>) exchangeRepository.findAll();
    }

    @Override
    public Optional<Exchange> findById(Long id) {
        return exchangeRepository.findById(id);
    }

    @Override
    public void save(Exchange exchange) {
        exchangeRepository.save(exchange);
    }

    @Override
    public void deleteById(Long id) {
        exchangeRepository.deleteById(id);
    }
}
