package com.example.firstbackend.controllers;

import com.example.firstbackend.models.entities.Product;
import com.example.firstbackend.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Controller -> Services -> Repo

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @PostMapping
    public Product create(@RequestBody Product product){
        return productServices.save(product);
    }

    @GetMapping
    public Iterable<Product> FindAll(){
        return productServices.FindAll();
    }

    @GetMapping("/{id}")
    public Product FindOne(@PathVariable("id") Long x){
        return productServices.findone(x);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        return productServices.save(product);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long x){
        productServices.removeOne(x);
    }

}

