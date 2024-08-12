package com.elyashevich.orders.web.mapper.contact;

public interface Mappable<E, D> {

    E toEntity(D dto);

    D toDto(E entity);
}
