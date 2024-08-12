package com.elyashevich.orders.domain.order;

import lombok.Getter;

@Getter
public enum OrderStatus {

    PENDING("pending"),
    FULFILLED("fulfilled"),
    REJECTED("rejected");

    private final String name;

    OrderStatus(String name) {
        this.name = name;
    }
}
