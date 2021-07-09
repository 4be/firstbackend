package com.example.firstbackend.models.repos;

import com.example.firstbackend.models.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category,Long> {

}
