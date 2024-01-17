package com.newpiece.rest.repository;

import com.newpiece.rest.entities.Exchange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExchangeRepository extends CrudRepository<Exchange, Long> {
}
