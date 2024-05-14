package com.upc.smartsproutbackend.repository;

import com.upc.smartsproutbackend.models.CropField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CropFieldRepository extends JpaRepository<CropField, Long> {
    CropField findByLocation(String location);
    List<CropField> findByCropType(String cropType);
}