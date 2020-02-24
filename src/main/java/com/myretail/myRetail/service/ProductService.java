package com.myretail.myRetail.service;

import com.myretail.myRetail.dao.Product;
import com.myretail.myRetail.exception.ProductException;
import com.myretail.myRetail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {

    // Will use this class to handle services

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Product product;

}
