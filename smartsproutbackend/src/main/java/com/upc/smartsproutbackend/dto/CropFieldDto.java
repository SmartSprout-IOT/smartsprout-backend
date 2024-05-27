package com.upc.smartsproutbackend.dto;


import com.upc.smartsproutbackend.models.IrrigationRecord;
import com.upc.smartsproutbackend.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CropFieldDto {
    private Long cropFieldId;
    private String cropFieldName;
    private String cropFieldDescription;
    private double latitudeData;
    private double longitudeData;
    private double cropFieldSize;
    private String soilType;
    private String cropType;
    private String cropVariety;
    private String cropPlant;
    private LocalDate cropPlantingDate;
    private Long numPlants;
    private int minTemperature;
    private int maxTemperature;
    private int minHumidity;
    private int maxHumidity;
    private List<IrrigationRecord> irrigationRecords = new ArrayList<>();
}
