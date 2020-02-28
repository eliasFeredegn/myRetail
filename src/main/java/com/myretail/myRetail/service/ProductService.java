package com.myretail.myRetail.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.myRetail.dao.Product;
import com.myretail.myRetail.fileHandler.FileHandler;
import com.myretail.myRetail.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

/**
 * @author: Elias
 * This class is used to handle request made by the controller and combines the necessary data together.
 */

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    FileHandler fileHandler;
    private static final Logger logger = LogManager.getLogger(ProductService.class);

    // This method is used to save data to database
    public void insertProductToDatabase(Product product) throws Exception {
        logger.info("ProductService.java --> inserProductToDatabase :: Start " + new ObjectMapper().writeValueAsString(product));
        //product.setProductName(getProductName());
        productRepository.save(product);
    }

    /** This method is used to delete data from the database */
    public void deleteProductFromDatabase(int id){
        productRepository.deleteById(id);
    }

    // This method is used to get all product from the database
    public List<Product> getAllProducts(){
        return (List<Product>) productRepository.findAll();
    }

    // This method is used to update a product that's in the database
    public int updateProductPrice(int id) throws Exception{
        logger.info("ProductService.java --> updateProductPrice :: START");
        Product product = getProductById(id);
        logger.info("ProductService.java --> getProductRepo :: END " + new ObjectMapper().writeValueAsString(product));
        return productRepository.updatePrice(product.getProductId(), product.getCurrentPrice());
    }

    // This method is used to get a specific product from the database using product id
    public Product getProductById(int productId) throws Exception{
        logger.info("ProductService.java --> getProductById :: START");
        // Converting product id to string since id is stored as string in file and json.
        String productIdString = String.valueOf(productId);
        // Get product name from api call
        String productName = getProductName((productIdString));
        //getting currency code from database
        Optional<Product> product = productRepository.findById(productId);
        System.out.println("Product id from database" + product.get().getProductId());
        // Retrieve product price from file
        String productPrice = fileHandler.getPrice(product.get().getProductId());
        System.out.println("Product price " + productPrice);
        float currentPrice = Float.parseFloat(productPrice);
        System.out.println(currentPrice);
        product.get().setCurrentPrice(currentPrice);
        product.get().setProductName(productName);
        logger.info("ProductService.java --> getProductById :: END " + new ObjectMapper().writeValueAsString(product));
        return product.get();
    }

    public String getProductName(String productId) throws JSONException{
        String productStr = restTemplate.getForObject("https://redsky.target.com/v2/pdp/tcin/"+productId+"?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics", String.class);
        JSONObject jsonObject = new JSONObject(productStr);
        JSONObject productDescription = jsonObject.getJSONObject("product").getJSONObject("item").getJSONObject("product_description");
        JSONObject productIdd = jsonObject.getJSONObject("product").getJSONObject("item");
        System.out.println("Product id is: "+productDescription.get("title") + " " + productIdd.get("tcin"));

        return productDescription.get("title").toString();

    }

}

