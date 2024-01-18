package com.newpiece.rest.persistence.impl;

import com.newpiece.rest.entities.CryptocurrencyEntity;
import com.newpiece.rest.persistence.ICryptocurrencyDAO;
import com.newpiece.rest.repository.ICryptocurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CryptocurrencyDAOImpl implements ICryptocurrencyDAO {

    @Autowired
    private ICryptocurrencyRepository cryptocurrencyRepository;
    @Override
    public List<CryptocurrencyEntity> findAll() {
        return (List<CryptocurrencyEntity>) cryptocurrencyRepository.findAll();
    }

    @Override
    public Optional<CryptocurrencyEntity> findById(Long id) {
        return cryptocurrencyRepository.findById(id);
    }

    @Override
    public void save(CryptocurrencyEntity cryptocurrencyEntity) {
        cryptocurrencyRepository.save(cryptocurrencyEntity);
    }

    @Override
    public void deleteById(Long id) {
        cryptocurrencyRepository.deleteById(id);
    }
}
