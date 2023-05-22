package com.example.demo.Product;

import com.example.demo.Category.Category;
import com.example.demo.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public Boolean existsById(Integer id){
        Boolean response = false;
        //response = productRepository.findById(id);
        response = productRepository.existsById(id);
        return response;
    }

    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }

    public Product getProduct(Integer id){
        Product product = null;
        Optional<Product> produtoExisteOptional  = productRepository.findById(id);

        if (produtoExisteOptional.isPresent()){
            product = new Product();
            product = produtoExisteOptional.get();
        }

        return product;
    }
}
