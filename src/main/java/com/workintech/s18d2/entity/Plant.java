package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass // Bu annotations plant tablosu olupşumu engeller. Bu bu class miras alımını sağlar.

public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull(message = "name cannot be null")
    @Size(min = 2 , max = 45, message = "name must be between 2 and 45")
    private String name;

    @Column(name = "price")
    @DecimalMin("10")
    private Double price;


}
