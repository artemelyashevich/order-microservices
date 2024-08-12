package com.elyashevich.orders.kafka;

import com.elyashevich.orders.web.dto.CustomerDto;
import com.elyashevich.orders.web.dto.ProductDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumerService {

    void listen(ConsumerRecord<String, String> dto);
}
