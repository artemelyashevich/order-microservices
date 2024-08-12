package com.elyashevich.orders.domain;

import com.elyashevich.orders.domain.contract.AbstractEntity;
import lombok.*;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product extends AbstractEntity {

    @TextIndexed
    private String name;

    private String quantity;

    private Double price;
}
