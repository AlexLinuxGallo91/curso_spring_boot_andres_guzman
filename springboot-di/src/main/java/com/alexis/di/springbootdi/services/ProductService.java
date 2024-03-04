package com.alexis.di.springbootdi.services;

import java.util.List;
import java.util.stream.Collectors;

import com.alexis.di.springbootdi.models.Product;
import com.alexis.di.springbootdi.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();

    public List<Product> findAll() {
        return this.repository.findAll().stream().map(p -> {
            Double priceImp = p.getPrice() * 1.25d;
            p.setPrice(priceImp.longValue());
            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return this.repository.findById(id);
    }

}
