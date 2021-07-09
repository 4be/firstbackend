package com.example.firstbackend.controllers;

import com.example.firstbackend.dto.ResponseData;
import com.example.firstbackend.dto.SearchData;
import com.example.firstbackend.models.entities.Product;
import com.example.firstbackend.models.entities.Supplier;
import com.example.firstbackend.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// Controller -> Services -> Repo

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    @PostMapping
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product, Errors errors){

        ResponseData<Product> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error:errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(productServices.save(product));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Product> findAll(){
        return productServices.FindAll();
    }

    @GetMapping("/{id}")
    public Product findone(@PathVariable("id") Long x){
        return productServices.findone(x);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Product>> update(@Valid @RequestBody Product product, Errors errors){
        ResponseData<Product> responseData = new ResponseData<>();

        if(errors.hasErrors()){
            for (ObjectError error:errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setStatus(true);
        responseData.setPayload(productServices.save(product));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long x){
        productServices.removeOne(x);
    }

    @PostMapping("/{id}") // asumsi input melalui drop down
    public void addSupplier(@RequestBody Supplier supplier, @PathVariable("id") Long productId){
        productServices.addSupplier(supplier, productId);
    }

    @PostMapping("/search/name") //POST MAPPING AKAN DI SIMPAN DI REQBODY & GETMAPPING DARI PATH VARIABLE
    public Product getProductByName(@RequestBody SearchData searchData){
        return productServices.findByProductName(searchData.getSearchKey());
    }

    @PostMapping("/search/smiliarname") //POST MAPPING AKAN DI SIMPAN DI REQBODY & GETMAPPING DARI PATH VARIABLE
    public List<Product> getProductBySmiliar(@RequestBody SearchData searchData){
        return productServices.findByProductSmiliar(searchData.getSearchKey());
    }

    @GetMapping("/search/category/{categoryId}")
    public List<Product> getProductByCategory(@PathVariable("categoryId") Long categoryId){
        return  productServices.findByCategoryId(categoryId);
    }

    @GetMapping("/search/supplier/{supplierId}")
    public List<Product> getProductBySupplier(@PathVariable("supplierId") Long supplierId){
        return  productServices.findBySupplier(supplierId);
    }

}

