package com.myretail.myRetail.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.myRetail.CreateProduct;
import com.myretail.myRetail.dao.Product;
import com.myretail.myRetail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;

@CrossOrigin(origins = "*")
@RestController
public class MyRetailController {

    private ProductService productService = new ProductService();
    private static final Logger logger = LogManager.getLogger(MyRetailController.class);
    private Product product = new Product();
    private static Map<Integer, Product> productRepo = new HashMap<>();

    @GetMapping("/product/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Integer id) throws Exception{
        logger.info("MyRetailController.java --> getProduct/{id}() :: START ");
        System.out.println(productRepo.get(id));
        logger.info("MyRetailController.java --> getProduct/{id}() :: END ");
        return new ResponseEntity<>(productRepo.get(id), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<Object> getProduct() {
        logger.info("MyRetailController.java --> getProducts/ :: START ");
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    /** This method is used to save products to hashmap **/
    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) throws Exception{
        logger.info("MyRetailController.java --> products/ :: START ");
        productRepo.put(product.getProductId(), product);
        logger.info("MyRetailController.java --> products/ :: END ");
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }

    /** This method takes product id as a variable and updates product. **/
    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        logger.info("MyRetailController.java --> products/{id} put method :: START ");
        ObjectMapper objectMapper = new ObjectMapper();
        productRepo.remove(id);
        product.setProductId(id);
        productRepo.put(id, product);
        logger.info("MyRetailController.java --> products/{id} put method :: END ");
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }
}
