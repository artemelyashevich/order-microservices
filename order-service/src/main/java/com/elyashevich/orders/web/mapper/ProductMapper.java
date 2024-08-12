package com.elyashevich.orders.web.mapper;

import com.elyashevich.orders.domain.Product;
import com.elyashevich.orders.web.mapper.contact.Mappable;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends Mappable<Product, String> {
}
