package com.newpiece.rest.service.impl;

import com.newpiece.rest.entities.ExchangeEntity;
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
    public List<ExchangeEntity> findAll() {
        return exchangeDAO.findAll();
    }

    @Override
    public Optional<ExchangeEntity> findById(Long id) {
        return exchangeDAO.findById(id);
    }

    @Override
    public void save(ExchangeEntity exchangeEntity) {
        exchangeDAO.save(exchangeEntity);
    }

    @Override
    public void deleteById(Long id) {
        exchangeDAO.deleteById(id);
    }
}
