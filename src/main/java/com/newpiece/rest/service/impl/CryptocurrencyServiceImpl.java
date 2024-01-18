package com.newpiece.rest.service.impl;

import com.newpiece.rest.entities.CryptocurrencyEntity;
import com.newpiece.rest.persistence.ICryptocurrencyDAO;
import com.newpiece.rest.service.ICryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CryptocurrencyServiceImpl implements ICryptocurrencyService {
    @Autowired
    private ICryptocurrencyDAO cryptocurrencyDAO;
    @Override
    public List<CryptocurrencyEntity> findAll() {
        return cryptocurrencyDAO.findAll();
    }

    @Override
    public Optional<CryptocurrencyEntity> findById(Long id) {
        return cryptocurrencyDAO.findById(id);
    }

    @Override
    public void save(CryptocurrencyEntity cryptocurrencyEntity) {
        cryptocurrencyDAO.save(cryptocurrencyEntity);
    }

    @Override
    public void deleteById(Long id) {
        cryptocurrencyDAO.deleteById(id);
    }
}
