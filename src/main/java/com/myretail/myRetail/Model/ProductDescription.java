package com.myretail.myRetail.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class ProductDescription {

    @JsonProperty("title")
    private String name;
    @JsonProperty("downstream_description")
    private String description;
    @JsonProperty("bullet_description")
    private String bulletDescription;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBulletDescription() {
        return bulletDescription;
    }

    public void setBulletDescription(String bulletDescription) {
        this.bulletDescription = bulletDescription;
    }
}
