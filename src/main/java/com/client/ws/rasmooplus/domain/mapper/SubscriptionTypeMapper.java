package com.client.ws.rasmooplus.domain.mapper;

import com.client.ws.rasmooplus.domain.dto.SubscriptionTypeDto;
import com.client.ws.rasmooplus.domain.model.SubscriptionType;

public class SubscriptionTypeMapper {

    private SubscriptionTypeMapper() {

    }

    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDto dto) {
        return SubscriptionType.builder()
                .id(dto.getId())
                .name(dto.getName())
                .accessMonths(dto.getAccessMonths())
                .price(dto.getPrice())
                .productKey(dto.getProductKey())
                .build();
    }
}