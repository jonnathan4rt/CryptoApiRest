package com.newpiece.rest.service.impl;

import com.newpiece.rest.entities.Exchange;
import com.newpiece.rest.persistence.IExchangeDAO;
import com.newpiece.rest.service.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExchangeServiceImpl implements IExchangeService {

    @Autowired
    private IExchangeDAO exchangeDAO;
    @Override
    public List<Exchange> findAll() {
        return exchangeDAO.findAll();
    }

    @Override
    public Optional<Exchange> findById(Long id) {
        return exchangeDAO.findById(id);
    }

    @Override
    public void save(Exchange exchange) {
        exchangeDAO.save(exchange);
    }

    @Override
    public void deleteById(Long id) {
        exchangeDAO.deleteById(id);
    }
}
