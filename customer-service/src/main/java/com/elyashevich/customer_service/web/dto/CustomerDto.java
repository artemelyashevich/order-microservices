package com.elyashevich.customer_service.web.dto;

import com.elyashevich.customer_service.web.dto.validation.OnCreate;
import com.elyashevich.customer_service.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record CustomerDto(
        String id,
        @NotNull(message = "Name must be not null", groups = {OnCreate.class, OnUpdate.class})
        @Length(
                max = 255,
                message = "Name length must be smaller than 250 symbols",
                groups = {OnCreate.class, OnUpdate.class}
        )
        @Length(
                min = 1,
                message = "Name length must be greatest than 1 symbol",
                groups = {OnCreate.class, OnUpdate.class}
        )
        String name,
        @Email(message = "Invalid email format", groups = {OnCreate.class, OnUpdate.class})
        String email,
        @NotNull(message = "Phone must be not null", groups = {OnCreate.class, OnUpdate.class})
        @Length(
                max = 13,
                message = "Phone length must be smaller than 13 symbols",
                groups = {OnCreate.class, OnUpdate.class}
        )
        @Length(
                min = 1,
                message = "Phone length must be greatest than 1 symbol",
                groups = {OnCreate.class, OnUpdate.class}
        )
        String phone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
