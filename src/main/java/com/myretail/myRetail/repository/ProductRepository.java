package com.myretail.myRetail.repository;

import com.myretail.myRetail.dao.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Product p SET p.currentPrice = :currentPrice WHERE p.id = :productId")
    int updatePrice(@Param("productId") int productId, @Param("currentPrice") float currentPrice);
}
