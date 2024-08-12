package com.elyashevich.orders.web.dto;


import lombok.Data;

import java.util.Objects;

@Data
public final class CustomerDto {
    private String id;
    private String name;
    private String email;
    private String phone;
}
