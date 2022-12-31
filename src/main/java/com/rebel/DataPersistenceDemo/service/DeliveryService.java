package com.rebel.DataPersistenceDemo.service;

import com.rebel.DataPersistenceDemo.entities.Delivery;
import com.rebel.DataPersistenceDemo.payloads.RecipientAndPrice;
import com.rebel.DataPersistenceDemo.repo.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService
{
    @Autowired
    private DeliveryRepository repo;

    //creating delivery
    public Long save(Delivery delivery)
    {
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        repo.persist(delivery);

        return delivery.getId();
    }

    //getting bill
    public RecipientAndPrice getBill(Long id)
    {
        return repo.getBill(id);
    }

}
