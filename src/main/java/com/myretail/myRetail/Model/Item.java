package com.myretail.myRetail.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class Item {

    @JsonProperty("tcin")
    private String tcin;
    @JsonProperty("product_description")
    private ProductDescription productDescription;


    public String getTcin() {
        return tcin;
    }

    public void setTcin(String tcin) {
        this.tcin = tcin;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

}
