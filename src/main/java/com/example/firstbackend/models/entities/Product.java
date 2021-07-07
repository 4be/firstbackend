package com.example.firstbackend.models.entities;
import javax.persistence.*;
import java.io.Serializable;

//Menhubungkan Entity kelas ke dalam Table Menggunakan JPA
@Entity
@Table(name = "tbl_product") //JPA akan check ke class yang terhubung dibawah
public class Product implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // untuk auto increment
    private Long id;                                    // set type data untuk table

    @Column(name="product_name",length = 100)
    private String name;

    @Column(name="product_description", length = 500)
    private String description;

    private Double price;

    //SET constructor kosong & berisi penuh + setter getter ( kalau pake lombok tidak perlu)
    public Product() {
    }

    public Product(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
