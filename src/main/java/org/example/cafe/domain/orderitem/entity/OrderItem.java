package org.example.cafe.domain.orderitem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int  orderedQuantity;
    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;



}
