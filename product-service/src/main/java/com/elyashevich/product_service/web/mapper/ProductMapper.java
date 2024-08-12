package com.elyashevich.product_service.web.mapper;

import com.elyashevich.product_service.domain.entity.Product;
import com.elyashevich.product_service.web.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product toEntity(ProductDto dto);
}
