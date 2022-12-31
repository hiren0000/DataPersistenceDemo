package com.rebel.DataPersistenceDemo.repo;


import com.rebel.DataPersistenceDemo.entities.Delivery;
import com.rebel.DataPersistenceDemo.entities.Plant;
import com.rebel.DataPersistenceDemo.payloads.RecipientAndPrice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository
{
    @PersistenceContext
    EntityManager entityManager;


    //getting the list of deliveries
    public List<Delivery> findDeliveriesByName(String name)
    {
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.findByName", Delivery.class);
        query.setParameter("name", name);
        return query.getResultList();
    }


    //Query for listing of plants with deliveryId matching
    //sum their price as well
    public RecipientAndPrice getBill(Long id)
    {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> query = cb.createQuery(RecipientAndPrice.class);
        Root<Plant> root = query.from(Plant.class);
        query.select(
                cb.construct(RecipientAndPrice.class,
                        root.get("delivery").get("name"),
                        cb.sum(root.get("price"))))
                        .where(cb.equal(root.get("delivery").get("id"), id));
        return entityManager.createQuery(query).getSingleResult();

    }



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
