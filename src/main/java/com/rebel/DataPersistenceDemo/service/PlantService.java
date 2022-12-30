package com.rebel.DataPersistenceDemo.service;

import com.rebel.DataPersistenceDemo.entities.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService
{
    public Plant getPlantByName(String name)
    {
        return new Plant();
    }



}
