package com.elyashevich.orders.kafka.impl;

import com.elyashevich.orders.domain.Event;
import com.elyashevich.orders.kafka.KafkaConsumerService;
import com.elyashevich.orders.web.dto.CustomerDto;
import com.elyashevich.orders.web.dto.OrderResponse;
import com.elyashevich.orders.web.dto.ProductDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private static final Gson gson = new GsonBuilder().create();

    @Override
    @KafkaListener(
            topics = "order",
            groupId = "main_topic"
    )
    public void listen(ConsumerRecord<String, String> record) {
        final var data = gson.fromJson(record.value(), OrderResponse.class);
        System.out.println("DATA FROM ORDER SERVICE --->" + data);
    }
}
