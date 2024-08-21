package com.elyashevich.product_service.kafka.impl;

import com.elyashevich.product_service.domain.Event;
import com.elyashevich.product_service.domain.order.OrderResponse;
import com.elyashevich.product_service.kafka.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, OrderResponse> template;

    @Override
    public void sendMessage(OrderResponse orderResponse) {
        this.template.send(
                "order",
                List.of(Event.CREATE_ORDER.toString(), Event.PRODUCT.toString()).toString(),
                orderResponse
        );
    }
}
