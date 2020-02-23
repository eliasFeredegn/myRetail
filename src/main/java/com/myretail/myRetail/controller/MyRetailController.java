package com.myretail.myRetail.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.myRetail.dao.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CrossOrigin(origins = "*")
@RestController
public class MyRetailController {

    @Autowired
    Product product;

    private static final Logger logger = LogManager.getLogger(MyRetailController.class);

    @GetMapping("/products")
    public ResponseEntity<Product> getproducts(@RequestParam("productId") int productId) throws Exception{
        logger.info("MyRetailController.java --> getProducts/{id}() :: START ");
        ObjectMapper objectMapper = new ObjectMapper();
        logger.info("MyRetailController.java --> getProducts/{id}() :: END "
                + objectMapper.writeValueAsString(product));
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
