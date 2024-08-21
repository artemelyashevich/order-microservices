package com.elyashevich.product_service.kafka;

import com.elyashevich.product_service.web.dto.ProductDto;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumerService {

    void listen(ConsumerRecord<String, String> record);
}
