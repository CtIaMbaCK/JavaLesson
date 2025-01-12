package com.vanlang.webbanhang.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "orders")
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;

    @OneToMany (mappedBy = "order")
    private List<OrderDetail> orderDetails;
}
