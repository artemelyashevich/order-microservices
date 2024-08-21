package com.elyashevich.customer_service.kafka;

import com.elyashevich.customer_service.domain.Event;
import com.elyashevich.customer_service.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, Order> template;

    @Override
    public void sendMessage(Order order) {
        this.template.send(
                "order",
                List.of(Event.CREATE_ORDER.toString(), Event.CUSTOMER.toString()).toString(),
                order
        );
    }
}
