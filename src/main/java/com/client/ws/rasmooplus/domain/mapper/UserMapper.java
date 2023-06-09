package com.client.ws.rasmooplus.domain.mapper;

import com.client.ws.rasmooplus.domain.model.jpa.SubscriptionType;
import com.client.ws.rasmooplus.domain.model.jpa.User;
import com.client.ws.rasmooplus.domain.model.jpa.UserType;
import com.client.ws.rasmooplus.dto.UserDto;

public class UserMapper {

    private UserMapper() {}

    public static User fromDtoToEntity(UserDto dto, UserType userType, SubscriptionType subscriptionType) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .cpf(dto.getCpf())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .dtSubscription(dto.getDtSubscription())
                .dtExpiration(dto.getDtExpiration())
                .userType(userType)
                .subscriptionType(subscriptionType)
                .build();
    }
}
