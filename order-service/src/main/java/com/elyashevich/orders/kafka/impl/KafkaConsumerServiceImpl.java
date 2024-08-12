package com.elyashevich.orders.kafka.impl;

import com.elyashevich.orders.domain.Event;
import com.elyashevich.orders.kafka.KafkaConsumerService;
import com.elyashevich.orders.web.dto.CustomerDto;
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
        final var keys = gson.fromJson(record.key(), List.class);
        Object data = null;
        switch (keys.get(1).toString()) {
            case ("PRODUCT"): {
                data = gson.fromJson(record.value(), ProductDto.class);
                break;
            }
            case ("CUSTOMER"): {
                data = gson.fromJson(record.value(), CustomerDto.class);
                break;
            }
        }
        System.out.println(data);
    }
}
