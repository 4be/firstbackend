package com.example.firstbackend.models.repos;

import com.example.firstbackend.models.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//bentuk harus interface dan mengextend ke product entity
public interface ProductRepo extends CrudRepository<Product, Long> {

        List<Product> findByNameContains(String name);

}
