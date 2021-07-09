package com.example.firstbackend.services;

import com.example.firstbackend.models.entities.Product;
import com.example.firstbackend.models.entities.Supplier;
import com.example.firstbackend.models.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service                                    //biasa digunakan untuk bisnis proses
@Transactional
public class ProductServices {

    @Autowired
    private ProductRepo productRepo;

    // kalau sudah ada primary key/ID dia dianggap update oleh JPA jika tidak ada maka CREATE
    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product findone(Long id){
        Optional<Product> product = productRepo.findById(id);
        if(!product.isPresent()){
            return null;
        }
        return product.get();
    }

    public Iterable<Product> FindAll(){
        return productRepo.findAll();
    }

    public void removeOne(Long id){
        productRepo.deleteById(id);
    }

    public List<Product> FindByName(String name){
        return productRepo.findByNameContains(name);
    }

    public void addSupplier(Supplier supplier,Long productId){
        Product product = findone(productId);
        if(product==null){
            throw new RuntimeException("Product with ID : "+productId+" not found");
        }
        product.getSuppliers().add(supplier);
        save(product);
    }

}
