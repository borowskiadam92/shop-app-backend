package com.sda.Shop.dto;

import com.sda.Shop.domain.Category;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
public class CreateProductDto {

    @NotNull
    private String name;
    @NotNull
    @Min(1)
    private BigDecimal price;
    @NotNull
    @Min(1)
    private Integer quantity;
    @NotNull
    private String description;
    @NotNull
    private Category category;

}
