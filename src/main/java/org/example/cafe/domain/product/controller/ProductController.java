package org.example.cafe.domain.product.controller;

import lombok.RequiredArgsConstructor;
import org.example.cafe.domain.product.dto.ProductDto;
import org.example.cafe.domain.product.entity.Product;
import org.example.cafe.domain.product.service.ProductService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private ProductService productService;

    //상품 목록 조회
    @GetMapping("/api/products")
    @Transactional(readOnly = true)
    public List<ProductDto> getProducts(){
        List<ProductDto> productList = productService.findAll()
                                        .stream()
                                        .map(ProductDto::new)
                                        .toList();

        return productList;
    }

    //상품 등록
    @PostMapping("/api/products")
    @Transactional
    public ProductDto createProduct(
            @RequestBody String name,
            @RequestBody int price,
            @RequestBody int quantity
    ){
        Product product = productService.create("name", price, quantity);
        return new ProductDto(product);
    }





    //상품 수정
    @PutMapping("/api/products")
    @Transactional
    public void updateProduct(
            @RequestBody int id,
            @RequestBody String name,
            @RequestBody int price,
            @RequestBody int quantity
    ){
        Product product = productService.findById(id).get();
        productService.modify(product, name, price, quantity);
    }


    //상품 삭제
    @DeleteMapping("/api/products")
    @Transactional
    public void deleteProduct(
            @RequestBody int id
    ){
        Product product = productService.findById(id).get();
        productService.delete(product);
    }

}
