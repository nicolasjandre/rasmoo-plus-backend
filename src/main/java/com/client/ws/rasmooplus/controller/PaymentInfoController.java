package com.client.ws.rasmooplus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.ws.rasmooplus.domain.service.PaymentInfoService;
import com.client.ws.rasmooplus.dto.PaymentProcessDto;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/payment")
public class PaymentInfoController {

    @Autowired
    private PaymentInfoService paymentInfoService;

    @PostMapping("/process")
    public ResponseEntity<Boolean> process(@Valid @RequestBody PaymentProcessDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentInfoService.process(dto));
    }
}
