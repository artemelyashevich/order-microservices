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
public class Address extends AbstractEntity {

    private String street;

    private String city;

    private String postCode;

    private String country;
}
