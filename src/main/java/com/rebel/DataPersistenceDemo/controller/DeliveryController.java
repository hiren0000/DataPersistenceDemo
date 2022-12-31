package com.rebel.DataPersistenceDemo.controller;

import com.rebel.DataPersistenceDemo.entities.Delivery;
import com.rebel.DataPersistenceDemo.payloads.RecipientAndPrice;
import com.rebel.DataPersistenceDemo.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/bill/{id}")
    public RecipientAndPrice getBill(@PathVariable Long id)
    {
        return service.getBill(id);
    }


}
