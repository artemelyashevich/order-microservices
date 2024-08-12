package com.elyashevich.product_service.web.dto;

import com.elyashevich.product_service.web.dto.validation.OnCreate;
import com.elyashevich.product_service.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record ProductDto(

        @NotNull(message = "Name must be not null", groups = {OnCreate.class, OnUpdate.class})
        @Length(
                max = 255,
                message = "Title length must be smaller than 250 symbols",
                groups = {OnCreate.class, OnUpdate.class}
        )
        @Length(
                min = 1,
                message = "Title length must be greatest than 1 symbol",
                groups = {OnCreate.class, OnUpdate.class}
        )
        String name,

        @NotNull(message = "Quantity must be not null", groups = {OnCreate.class, OnUpdate.class})
        Integer quantity,

        @NotNull(message = "Price must be not null", groups = {OnCreate.class, OnUpdate.class})
        Double price
) {
}