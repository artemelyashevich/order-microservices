package com.elyashevich.customer_service.kafka;

import com.elyashevich.customer_service.domain.Event;
import com.elyashevich.customer_service.domain.entity.Customer;
import com.elyashevich.customer_service.web.dto.CustomerDto;
import com.elyashevich.customer_service.web.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, CustomerDto> template;

    private final CustomerMapper customerMapper;

    @Override
    public void sendMessage(Customer customer) {
        this.template.send(
                "order",
                List.of(Event.CREATE_ORDER.toString(), Event.CUSTOMER.toString()).toString(),
                this.customerMapper.toDto(customer)
        );
    }
}
