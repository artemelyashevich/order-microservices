package com.elyashevich.product_service.kafka.impl;

import com.elyashevich.product_service.domain.order.OrderRequest;
import com.elyashevich.product_service.domain.order.OrderResponse;
import com.elyashevich.product_service.kafka.KafkaConsumerService;
import com.elyashevich.product_service.kafka.KafkaProducerService;
import com.elyashevich.product_service.service.ProductService;
import com.elyashevich.product_service.web.mapper.ProductMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private static final Gson gson = new GsonBuilder().create();
    private final KafkaProducerService kafkaProducerService;
    private final ProductService productService;
    private final ProductMapper productMapper;

    @Override
    @KafkaListener(
            topics = "customer",
            groupId = "customer_topic"
    )
    public void listen(ConsumerRecord<String, String> record) {
        final var data = gson.fromJson(record.value(), OrderRequest.class);
        final var product = this.productService.getById(data.getProductId());
        this.kafkaProducerService.sendMessage(
                OrderResponse
                .builder()
                        .productDto(this.productMapper.toDto(product))
                        .customerDto(data.getDto())
                        .build()
        );
    }
}
