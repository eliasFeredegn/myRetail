package com.myretail.myRetail.service;

import com.myretail.myRetail.dao.Product;
import com.myretail.myRetail.exception.ProductException;
import com.myretail.myRetail.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    // Will use this class to handle services

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private Product product;

    public void insertProductToDatabase(Product product){
        productRepository.save(product);
    }

    public void deleteProductFromDatabase(int id){
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    public Product getProductById(int id) throws Exception{
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new Exception("Couldn't find a product wit hid: " + id));
    }



}
