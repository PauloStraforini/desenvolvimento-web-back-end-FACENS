package com.example.aula2.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula2.models.Product;

@RestController
public class ProductController {
    ArrayList<Product> products = new ArrayList<>();

    @PostMapping("/products")
    public String create(@RequestBody Product product) {
        products.add(product);
        return "Product created";
    }

    @GetMapping("/products/get")
    public ArrayList<Product> getAll() {
        return products;
    }

    @PutMapping("/products/id")
    public String update(@PathVariable int id, @RequestBody Product updatedProduct) {
        Optional<Product> existingProduct = products.stream()
            .filter(product -> product.getId() == id)
            .findFirst();

        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            productToUpdate.setName(updatedProduct.getName());
            productToUpdate.setPrice(updatedProduct.getPrice());

            return "Product updated";
        } else {
            return "Product not found";
        }
    }

}
