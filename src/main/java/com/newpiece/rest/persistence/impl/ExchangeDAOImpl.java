package com.newpiece.rest.persistence.impl;

import com.newpiece.rest.entities.ExchangeEntity;
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
    public List<ExchangeEntity> findAll() {
        return (List<ExchangeEntity>) exchangeRepository.findAll();
    }

    @Override
    public Optional<ExchangeEntity> findById(Long id) {
        return exchangeRepository.findById(id);
    }

    @Override
    public void save(ExchangeEntity exchangeEntity) {
        exchangeRepository.save(exchangeEntity);
    }

    @Override
    public void deleteById(Long id) {
        exchangeRepository.deleteById(id);
    }
}
