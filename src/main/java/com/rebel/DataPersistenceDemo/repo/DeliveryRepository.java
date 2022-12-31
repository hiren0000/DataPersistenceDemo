package com.rebel.DataPersistenceDemo.repo;


import com.rebel.DataPersistenceDemo.entities.Delivery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class DeliveryRepository
{
    @PersistenceContext
    EntityManager entityManager;

    //creating delivery
    public void persist(Delivery delivery)
    {
        entityManager.persist(delivery);

    }

    //find the delivery by id
    public Delivery find(Long id)
    {
        return entityManager.find(Delivery.class,id);
    }

    //merge or updating entity
    public Delivery merge(Delivery delivery)
    {
        return  entityManager.merge(delivery);
    }

    //delete entity
    public void delete(Long id)
    {
        Delivery delivery =entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }

}
