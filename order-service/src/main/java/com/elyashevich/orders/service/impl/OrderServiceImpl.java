package com.elyashevich.orders.service.impl;

import com.elyashevich.orders.domain.order.Order;
import com.elyashevich.orders.repository.OrderRepository;
import com.elyashevich.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order getById(String id) {
        return this.orderRepository.findById(id)
                .orElseThrow(
                        () -> new NoSuchElementException("Order with such id = %s was not found".formatted(id))
                );
    }

    @Override
    public List<Order> getAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        final Order newOrder = Order
                .builder()
                .build();
        return order;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public void delete(String id) {
        this.orderRepository.delete(
                this.getById(id)
        );
    }
}
