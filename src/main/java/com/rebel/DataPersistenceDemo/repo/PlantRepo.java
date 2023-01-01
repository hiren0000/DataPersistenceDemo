package com.rebel.DataPersistenceDemo.repo;

import com.rebel.DataPersistenceDemo.entities.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface PlantRepo extends JpaRepository<Plant, Long>
{
    public boolean isPlantDelivered(Long id);

    public List<Plant> plantsCheaperThanSpecifiedPrice(BigDecimal price);
}
