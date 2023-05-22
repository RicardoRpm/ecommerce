package com.example.demo.Category;

import jakarta.persistence.*;

@Entity
@Table
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.IDENTITY,
        generator = "category_sequence"
    )
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    public Category(){}

    public Category(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

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

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
