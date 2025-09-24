package org.example.cafe.domain.product.service;

import org.example.cafe.domain.product.entity.Product;
import org.example.cafe.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private ProductRepository productRepository;


    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product create(String name, int price, int quantity) {
        Product product = new Product(name, price, quantity);

        return productRepository.save(product);
    }
}
