package com.example.demo.Category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CategoryConfig {
    @Bean
    CommandLineRunner commandLineRunner(CategoryRepository repository){
        return args -> {
            Category cat1 = new Category(
                    1,
                    "Teste 1",
                    "Description 1 - Teste 1"
            );

            Category cat2 = new Category(
                    1,
                    "Teste 2",
                    "Description 2 - Teste 2"
            );

            repository.saveAll(List.of(cat1, cat2));
        };
    }
}
