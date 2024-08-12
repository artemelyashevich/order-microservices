package com.elyashevich.product_service.kafka;

import com.elyashevich.product_service.domain.Event;
import com.elyashevich.product_service.domain.entity.Product;
import com.elyashevich.product_service.web.dto.ProductDto;
import com.elyashevich.product_service.web.mapper.ProductMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, ProductDto> template;

    private final ProductMapper productMapper;

    @Override
    public void sendMessage(Product product) {
        this.template.send(
                "order",
                List.of(Event.CREATE_ORDER.toString(), Event.PRODUCT.toString()).toString(),
                this.productMapper.toDto(product)
        );
    }
}
