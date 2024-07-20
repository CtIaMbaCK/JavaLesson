package com.vanlang.webbanhang.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity //khai báo class la 1 entity dai dien cho 1 bang trong csdl
@Table (name = "products") // bảng ánh xạ đến
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private String description;

    @ManyToOne
    @JoinColumn (name = "category_id")
    private Category category;

}
