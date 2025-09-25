package org.example.cafe.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.cafe.domain.product.entity.Product;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    String name;
    int price;
    int quantity;

    public ProductDto(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }
}
