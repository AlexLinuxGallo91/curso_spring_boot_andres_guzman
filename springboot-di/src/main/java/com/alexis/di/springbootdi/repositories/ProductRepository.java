package com.alexis.di.springbootdi.repositories;

import java.util.Arrays;
import java.util.List;

import com.alexis.di.springbootdi.models.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "memory corsair 32GB", 300L),
                new Product(2L, "CPU Ryzen 5", 3400L),
                new Product(3L, "teclado racer mini", 180L),
                new Product(4L, "motherboard gigabyte", 200L));
    }

    public List<Product> findAll() {
        return this.data;
    }

    public Product findById(Long id) {
        return data.stream().filter(
                p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
