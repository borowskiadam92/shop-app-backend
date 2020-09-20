package com.sda.Shop.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class UpdateProductDto {

    @NotNull
    @Min(1)
    private BigDecimal Price;
    @NotNull
    @Min(1)
    private Integer quantity;
    @NotNull
    private String description;
}
