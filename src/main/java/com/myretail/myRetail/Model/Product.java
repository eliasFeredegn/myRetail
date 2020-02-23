package com.myretail.myRetail.Model;

import org.springframework.stereotype.Service;

@Service
public class Product {

    private String name;
    private int quanity;
    private String description;

    public Product(){
        this.name = "Elias";
        this.quanity = 5;
        this.description = "Laptops";
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
