package com.myretail.myRetail.dao;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Component
@Table(name="PRODUCTS")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="PRODUCT_ID")
    private int productId;
    @Column(name="PRODUCT_NAME")
    private String productName;
    @Column(name="CURRENT_PRICE")
    private float currentPrice;
    @Column(name="CURRENCY_CODE")
    private String currencyCode;

    public Product(){
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }


}
