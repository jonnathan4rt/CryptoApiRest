package com.newpiece.rest.repository;

import com.newpiece.rest.entities.Cryptocurrency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICryptocurrencyRepository extends CrudRepository<Cryptocurrency, Long> {
}
