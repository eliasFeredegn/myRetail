package com.myretail.myRetail.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.myRetail.dao.Product;
import com.myretail.myRetail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Author: Elias Feredegn
 *
 */

@RestController
public class MyRetailController {

    @Autowired
    private ProductService productService;
    private static final Logger logger = LogManager.getLogger(MyRetailController.class);

    /** This method is used to get a product using an id from the database. */
    @GetMapping("/product/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Integer id) throws Exception{
        logger.info("MyRetailController.java --> getProduct/{id}() :: START ");
        Product product = productService.getProductById(id);
        logger.info("MyRetailController.java --> getProduct/{id}() :: END ");
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /** This method return all products from the database */
    @GetMapping("/products")
    public ResponseEntity<Object> getProduct() {
        logger.info("MyRetailController.java --> getProducts/ :: START ");
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    /** This method is used to save products a database **/
    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) throws Exception{
        logger.info("MyRetailController.java --> products/ :: START ");
        productService.insertProductToDatabase(product);
        logger.info("MyRetailController.java --> products/ :: END ");
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    /** This method takes product id as a variable and updates product. **/
    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) throws Exception{
        logger.info("MyRetailController.java --> products/{id} put method :: START ");
        ObjectMapper objectMapper = new ObjectMapper();
        productService.updateProductPrice(id);
        logger.info("MyRetailController.java --> products/{id} put method :: END " + objectMapper.writeValueAsString(product));
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }
}
