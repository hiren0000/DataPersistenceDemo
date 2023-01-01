package com.rebel.DataPersistenceDemo.repo;

import com.rebel.DataPersistenceDemo.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface PlantRepo extends JpaRepository<Plant, Long>
{
    //check if a plant by this id exists where delivery has been completed
    public Boolean isPlantDelivered(Long id, Boolean delivered );


    //we can return primitive directly
    @Query("select p.delivery.completed from Plant p where p.id =:id")
    Boolean deliveryCompleted(Long id);

    //
    @Query("select new java.lang.Boolean(p.delivery.completed) from Plant p where p.id = :id")
    Boolean deliveryCompletedBoolean(Long id);


    public List<Plant> plantsCheaperThanSpecifiedPrice(BigDecimal price);
}
