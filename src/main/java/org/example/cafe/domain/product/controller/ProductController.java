package org.example.cafe.domain.product.controller;

import lombok.RequiredArgsConstructor;
import org.example.cafe.domain.product.entity.Product;
import org.example.cafe.domain.product.service.ProductService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private ProductService productService;

    //상품 목록 조회
    @GetMapping("/api/products")
    @Transactional(readOnly = true)
    public List<Product> getProducts(){
        List<Product> products = productService.findAll();

        return products;
    }

    //상품 등록
    @PostMapping("/api/products")
    @Transactional
    public Product createProduct(
            @RequestBody String name,
            @RequestBody int price,
            @RequestBody int quantity
    ){
        Product product = productService.create("name", price, quantity);
        return product;
    }

    //상품 수정

    //상품 삭제

}
