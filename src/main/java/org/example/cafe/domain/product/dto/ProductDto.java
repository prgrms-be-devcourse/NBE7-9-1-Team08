package org.example.cafe.domain.product.dto;

import org.example.cafe.domain.product.entity.Product;

public record ProductDto (
        int id,
        String Name,
        int price,
        int quantity
    ){
    public ProductDto(Product product){
        this(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}
