package com.myretail.myRetail.fileHandler;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Elias
 * Will be using this class to store price in a file
 *
 * */

@Component
public class FileHandler {

    private String fileName = "price.txt";

    public String getPrice(int productId) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));
        Map<String, String> productPrices = new HashMap<>();
        while (input.hasNext()) {
            productPrices.put(input.next(), input.next());
        }

        return productPrices.get(String.valueOf(productId));
    }

}

