package com.elyashevich.customer_service.web.mapper;

import com.elyashevich.customer_service.domain.entity.Customer;
import com.elyashevich.customer_service.web.dto.CustomerDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    List<CustomerDto> toDto(List<Customer> customers);

    CustomerDto toDto(Customer customer);

    Customer toEntity(CustomerDto dto);
}
