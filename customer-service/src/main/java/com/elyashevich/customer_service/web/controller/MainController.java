package com.elyashevich.customer_service.web.controller;

import com.elyashevich.customer_service.domain.entity.Customer;
import com.elyashevich.customer_service.kafka.KafkaProducerService;
import com.elyashevich.customer_service.service.CustomerService;
import com.elyashevich.customer_service.web.dto.CustomerDto;
import com.elyashevich.customer_service.web.dto.validation.OnCreate;
import com.elyashevich.customer_service.web.dto.validation.OnUpdate;
import com.elyashevich.customer_service.web.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
@Validated
public class MainController {

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    private final KafkaProducerService kafkaProducerService;

    @GetMapping
    public List<CustomerDto> getAll() {
        final var customers = this.customerService.getAll();
        return this.customerMapper.toDto(customers);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto create(final @Validated(OnCreate.class) @RequestBody CustomerDto dto) {
        final var customer = this.customerService.create(this.customerMapper.toEntity(dto));
        return this.customerMapper.toDto(customer);
    }

    @GetMapping("{id}")
    public CustomerDto getById(final @PathVariable("id") String id) {
        final var customer = this.customerService.getById(id);
        this.kafkaProducerService.sendMessage(customer);
        return this.customerMapper.toDto(customer);
    }

    @PatchMapping("{id}")
    public CustomerDto update(
            final @PathVariable("id") String id,
            final @Validated(OnUpdate.class) @RequestBody CustomerDto dto
    ) {
        final var customer = this.customerService.update(id, this.customerMapper.toEntity(dto));
        return this.customerMapper.toDto(customer);
    }

    @DeleteMapping("{id}")
    public void delete(final @PathVariable("id") String id) {
        this.customerService.delete(id);
    }

}
