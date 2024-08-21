package com.elyashevich.product_service.web.dto;

import com.elyashevich.product_service.web.dto.validation.OnCreate;
import com.elyashevich.product_service.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Objects;

public final class ProductDto {
    private final @NotNull(message = "Name must be not null", groups = {OnCreate.class, OnUpdate.class}) @Length(
            max = 255,
            message = "Title length must be smaller than 250 symbols",
            groups = {OnCreate.class, OnUpdate.class}
    ) @Length(
            min = 1,
            message = "Title length must be greatest than 1 symbol",
            groups = {OnCreate.class, OnUpdate.class}
    ) String name;
    private final @NotNull(message = "Quantity must be not null", groups = {OnCreate.class, OnUpdate.class}) Integer quantity;
    private final @NotNull(message = "Price must be not null", groups = {OnCreate.class, OnUpdate.class}) Double price;

    public ProductDto(

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
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public @NotNull(message = "Name must be not null", groups = {OnCreate.class, OnUpdate.class}) @Length(
            max = 255,
            message = "Title length must be smaller than 250 symbols",
            groups = {OnCreate.class, OnUpdate.class}
    ) @Length(
            min = 1,
            message = "Title length must be greatest than 1 symbol",
            groups = {OnCreate.class, OnUpdate.class}
    ) String name() {
        return name;
    }

    public @NotNull(message = "Quantity must be not null", groups = {OnCreate.class, OnUpdate.class}) Integer quantity() {
        return quantity;
    }

    public @NotNull(message = "Price must be not null", groups = {OnCreate.class, OnUpdate.class}) Double price() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ProductDto) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.quantity, that.quantity) &&
                Objects.equals(this.price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity, price);
    }

    @Override
    public String toString() {
        return "ProductDto[" +
                "name=" + name + ", " +
                "quantity=" + quantity + ", " +
                "price=" + price + ']';
    }

}