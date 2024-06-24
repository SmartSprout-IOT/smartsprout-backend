package com.upc.smartsproutbackend.service;

import com.upc.smartsproutbackend.dto.IdealConditionsDto;
import com.upc.smartsproutbackend.dto.IrrigationSuggestionDto;
import com.upc.smartsproutbackend.dto.ManageConfigurationSensorDto;
import com.upc.smartsproutbackend.models.IrrigationSuggestion;

public interface IoTSensorService {
    public abstract IdealConditionsDto getIdealConditions(Long cropFieldId);
    public abstract ManageConfigurationSensorDto manageConfigurationSensor();
    public abstract IrrigationSuggestion saveIrrigationSuggestion(Long cropFieldId);
    public abstract IrrigationSuggestionDto updateIrrigationSuggestion(IrrigationSuggestionDto irrigationSuggestionDto);
}
