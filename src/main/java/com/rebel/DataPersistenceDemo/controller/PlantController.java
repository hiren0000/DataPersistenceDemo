package com.rebel.DataPersistenceDemo.controller;

import com.rebel.DataPersistenceDemo.entities.Plant;
import com.rebel.DataPersistenceDemo.payloads.PlantDto;
import com.rebel.DataPersistenceDemo.service.PlantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plant")
public class PlantController
{
    @Autowired
    private PlantService service;

    //getting the object values using DTO
    public PlantDto getPlantDto(String name)
    {
        return convertEntityToDTO(service.getPlantByName(name));
    }



    private PlantDto convertEntityToDTO(Plant plant)
    {
        PlantDto dto = new PlantDto();
        BeanUtils.copyProperties(plant, dto);
        return dto;

    }

}
