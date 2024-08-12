package com.elyashevich.orders.domain;

import com.elyashevich.orders.domain.contract.AbstractEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends AbstractEntity {

    private String name;

    private String email;

    private String phone;
}
