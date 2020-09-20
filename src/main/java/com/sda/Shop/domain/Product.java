package com.sda.Shop.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
public class Product {

    @Setter
    private Long id;
    @Setter
    private String name;
    @Setter
    private BigDecimal price;
    @Setter
    private Integer quantity;
    @Setter
    private String description;

    private Category category;

    private LocalDateTime creationTime;

}
