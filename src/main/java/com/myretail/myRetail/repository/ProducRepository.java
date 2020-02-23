package com.myretail.myRetail.repository;

import com.myretail.myRetail.dao.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProducRepository extends CrudRepository<Product, Integer> {
}
