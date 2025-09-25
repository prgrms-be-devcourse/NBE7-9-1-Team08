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
    private final ProductService productService;

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


    //상품 등록 -> DB확인까지완료
    @PostMapping("/api/products")
    @Transactional
    public ProductDto createProduct(
            @RequestBody ProductDto productDto
    ){
        System.out.println(productDto.getName()+" "+productDto.getPrice()+" "+productDto.getQuantity());
        Product product = productService.create(productDto.getName(),productDto.getPrice(),productDto.getQuantity());

        System.out.println(product.getName()+" "+product.getPrice()+" "+product.getQuantity());
        return new ProductDto(product);
    }



    //pull request

    //상품 수정
    @PutMapping("/api/products")
    @Transactional
    public void updateProduct(
            @RequestBody ProductDto productDto
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
