package com.elyashevich.orders.service;

import com.elyashevich.orders.domain.order.Order;

import java.util.List;

public interface OrderService {

    Order getById(String id);

    List<Order> getAll();

    Order create(Order order);

    Order update(Order order);

    void delete(String id);
}
