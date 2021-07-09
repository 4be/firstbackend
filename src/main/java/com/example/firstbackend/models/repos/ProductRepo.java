package com.example.firstbackend.models.repos;

import com.example.firstbackend.models.entities.Product;
import com.example.firstbackend.models.entities.Supplier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.websocket.server.PathParam;
import java.util.List;

//bentuk harus interface dan mengextend ke product entity
public interface ProductRepo extends CrudRepository<Product, Long> {

        @Query("SELECT p FROM Product p WHERE p.name = :name")
        public Product findProductByName(@PathParam("name") String name);

        @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
        public List<Product> findProductSmiliar(@PathParam("name") String name);

        @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
        public List<Product> findProductByCategory(@PathParam("categoryId") Long categoryId);

        @Query("SELECT p FROM Product p WHERE :supplier MEMBER OF p.suppliers")
        public List<Product> findProdcutBySupplier(@PathParam("supplier") Supplier supplier); // langsung dari object

}
