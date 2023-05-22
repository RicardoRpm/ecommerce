package com.example.demo.Product;

import jakarta.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "product_sequence"
    )
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String img;

    public Integer getId(){
        return id;
    }

    public void setId(Integer Id){
        this.id = Id;
    }

    public String getName(){
        return name;
    }

    public void setName(String Name){
        this.name = Name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double Price){
        this.price = Price;
    }

    public String getImg(){
        return img;
    }

    public void setImg(String Img){
        this.img = Img;
    }
}
