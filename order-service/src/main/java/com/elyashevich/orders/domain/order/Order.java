package com.elyashevich.orders.domain.order;

import com.elyashevich.orders.domain.Customer;
import com.elyashevich.orders.domain.Product;
import com.elyashevich.orders.domain.contract.AbstractEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order extends AbstractEntity {

    @DBRef
    private List<Product> products;

    private Customer customer;

    private OrderStatus orderStatus;

    private Double totalPrice;
}
