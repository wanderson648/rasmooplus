package com.client.ws.rasmooplus.controller;

import com.client.ws.rasmooplus.model.SubscriptionType;
import com.client.ws.rasmooplus.model.dto.SubscriptionTypeDto;
import com.client.ws.rasmooplus.service.SubscriptionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/subscription-type")
@RequiredArgsConstructor
public class SubscriptionTypeController {

    private final SubscriptionTypeService subscriptionTypeService;

    @GetMapping
    public ResponseEntity<List<SubscriptionType>> findAll() {
        return ResponseEntity.status(OK).body(subscriptionTypeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionType> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(OK).body(subscriptionTypeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<SubscriptionType> create(@RequestBody SubscriptionTypeDto dto) {
        return ResponseEntity.status(CREATED).body(subscriptionTypeService.create(dto));
    }

}