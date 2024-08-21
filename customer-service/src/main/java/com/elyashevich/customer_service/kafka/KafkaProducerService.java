package com.elyashevich.customer_service.kafka;

import com.elyashevich.customer_service.domain.Order;
import com.elyashevich.customer_service.domain.entity.Customer;

public interface KafkaProducerService {

    void sendMessage(Order order);
}
