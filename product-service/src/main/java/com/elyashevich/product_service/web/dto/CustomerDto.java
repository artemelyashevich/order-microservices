package com.elyashevich.product_service.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
public class CustomerDto {

    private String id;

    @NotNull(message = "Name must be not null")
    @Length(
            max = 255,
            message = "Name length must be smaller than 250 symbols"
    )
    @Length(
            min = 1,
            message = "Name length must be greatest than 1 symbol"
    )
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Phone must be not null")
    @Length(
            max = 13,
            message = "Phone length must be smaller than 13 symbols"
    )
    @Length(
            min = 1,
            message = "Phone length must be greatest than 1 symbol"
    )
    private String phone;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
