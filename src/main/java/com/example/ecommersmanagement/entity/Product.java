package com.example.ecommersmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product", schema = "e_commerse")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Basic
    @Column(name = "brand")
    private @NotNull String brand;
    @Basic
    @Column(name = "model")
    private @NotNull String model;
    @Basic
    @Column(name = "price")
    private @NotNull double price;

    @ManyToOne
    @JoinColumn(name="catgory_id")
    Category category;


}
