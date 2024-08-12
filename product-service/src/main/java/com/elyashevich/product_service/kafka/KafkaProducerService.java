package com.elyashevich.product_service.kafka;

import com.elyashevich.product_service.domain.entity.Product;

public interface KafkaProducerService {

    void sendMessage(Product product);
}
