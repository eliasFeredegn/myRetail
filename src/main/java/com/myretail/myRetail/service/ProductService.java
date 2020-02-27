package com.myretail.myRetail.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.myRetail.Model.Item;
import com.myretail.myRetail.Model.Product;
import com.myretail.myRetail.Model.ProductDescription;
import com.myretail.myRetail.Model.ProductInfo;
import com.myretail.myRetail.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Item item;
    @Autowired
    private ProductDescription productDescription;
    @Autowired
    private ProductInfo productInfo;


    @Value("https://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics")
    private String url;

    private static final Logger logger = LogManager.getLogger(ProductService.class);

    // This method is used to save data to database
    public void insertProductToDatabase(Product product) throws Exception{
        logger.info("ProductService.java --> inserProductToDatabase :: Start " + new ObjectMapper().writeValueAsString(product));
        productRepository.save(product);
    }

    // This method is used to delete data from the database
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
    public Product getProductById(int id) throws Exception{
        logger.info("ProductService.java --> getProductById :: START");
        Optional<Product> product = productRepository.findById(id);
        logger.info("ProductService.java --> getProductById :: END " + new ObjectMapper().writeValueAsString(product));
        return product.orElseThrow(() -> new Exception("Couldn't find a product with id: " + id));
    }

    public void getProductInfo(){
        ProductInfo product = restTemplate.getForObject(url, ProductInfo.class);

        String name = product.getItem().getProductDescription().getName();

        System.out.println(name);

    }

}
