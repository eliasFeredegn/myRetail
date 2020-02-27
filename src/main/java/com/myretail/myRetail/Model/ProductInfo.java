package com.myretail.myRetail.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class ProductInfo {

    @JsonProperty("available_to_promise_network")
    private AvailableToPromiseNetwork availableToPromiseNetwork;
    @JsonProperty("item")
    private Item item;

    public AvailableToPromiseNetwork getAvailableToPromiseNetwork() {
        return availableToPromiseNetwork;
    }

    public void setAvailableToPromiseNetwork(AvailableToPromiseNetwork availableToPromiseNetwork) {
        this.availableToPromiseNetwork = availableToPromiseNetwork;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
