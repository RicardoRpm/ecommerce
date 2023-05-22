package com.example.demo.Client;

import jakarta.persistence.*;

@Entity
@Table
public class Client {

    public Client(){}

    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName = "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "client_sequence"
    )
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

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

    public String getEmail(){
        return email;
    }

    public void setEmail(String Email){
        this.email = Email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String Password){
        this.password = Password;
    }
}
