package com.client.ws.rasmooplus.domain.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.ws.rasmooplus.domain.exception.BadRequestException;
import com.client.ws.rasmooplus.domain.exception.NotFoundException;
import com.client.ws.rasmooplus.domain.mapper.UserMapper;
import com.client.ws.rasmooplus.domain.model.jpa.SubscriptionType;
import com.client.ws.rasmooplus.domain.model.jpa.User;
import com.client.ws.rasmooplus.domain.model.jpa.UserType;
import com.client.ws.rasmooplus.domain.repository.jpa.SubscriptionTypeRepository;
import com.client.ws.rasmooplus.domain.repository.jpa.UserRepository;
import com.client.ws.rasmooplus.domain.repository.jpa.UserTypeRepository;
import com.client.ws.rasmooplus.domain.service.UserService;
import com.client.ws.rasmooplus.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private SubscriptionTypeRepository subscriptionTypeRepository;

    @Override
    public User create(UserDto dto) {

        if (Objects.nonNull(dto.getId())) {
            throw new BadRequestException("Não pode haver um id no body");
        }

        var optionalUserType = userTypeRepository.findById(dto.getUserTypeId());

        if (optionalUserType.isEmpty()) {
            throw new NotFoundException("UserTypeId id=[" + dto.getUserTypeId() + "] não encontrado");
        }

        UserType userType = optionalUserType.get();
        User user = UserMapper.fromDtoToEntity(dto, userType, null);
        return userRepository.save(user);
    }

    public void updateUserSubscriptionType(User user, String productKey) {

        if (Objects.isNull(user.getId())) {
            throw new BadRequestException("O id do usuário não pode estar vazio");
        }

        Optional<User> userOpt = userRepository.findById(user.getId());

        if (userOpt.isEmpty()) {
            throw new NotFoundException("Usuário de id=[" + user.getId() + "] não encontrado");
        }

        Optional<SubscriptionType> subscriptionTypeOpt = subscriptionTypeRepository.findByProductKey(productKey);

        if (subscriptionTypeOpt.isEmpty()) {
            throw new NotFoundException("Subscription type de key=[" + productKey + "] não encontrado");
        }

        user.setSubscriptionType(subscriptionTypeOpt.get());
        userRepository.save(user);
    }
}
