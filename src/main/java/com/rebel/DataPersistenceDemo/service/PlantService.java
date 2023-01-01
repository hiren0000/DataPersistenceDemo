package com.rebel.DataPersistenceDemo.service;

import com.rebel.DataPersistenceDemo.entities.Plant;
import com.rebel.DataPersistenceDemo.repo.PlantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PlantService
{
   @Autowired
    private PlantRepo repo;

   //Plant creating
   public Long save(Plant plant)
   {
       Plant createdPlant = this.repo.save(plant);

       return createdPlant.getId();
   }

   //finding all the cheaper plants than specified price
   public List<Plant> getALlCheaperPlant(BigDecimal price)
   {
       return this.repo.plantsCheaperThanSpecifiedPrice(price);
   }

    //checking if plant is delivered
    public boolean plantDeliverd(Long id)
    {
        return this.repo.isPlantDelivered(id);
    }

}
