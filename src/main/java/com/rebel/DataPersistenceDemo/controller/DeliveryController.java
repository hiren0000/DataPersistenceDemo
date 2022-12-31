package com.rebel.DataPersistenceDemo.controller;

import com.rebel.DataPersistenceDemo.entities.Delivery;
import com.rebel.DataPersistenceDemo.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery")
public class DeliveryController
{
    @Autowired
    private DeliveryService service;

    @PostMapping
    public Long scheduleDelivery(@RequestBody Delivery delivery)
    {
        return service.save(delivery);
    }


}
