package com.upc.smartsproutbackend.service.impl;

import com.upc.smartsproutbackend.exception.ResourceNotFoundException;
import com.upc.smartsproutbackend.models.CropField;
import com.upc.smartsproutbackend.models.IrrigationRecord;
import com.upc.smartsproutbackend.models.User;
import com.upc.smartsproutbackend.repository.CropFieldRepository;
import com.upc.smartsproutbackend.repository.IrrigationRecordRepository;
import com.upc.smartsproutbackend.service.CropFieldService;
import com.upc.smartsproutbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class CropFieldServiceImpl implements CropFieldService {
    private final IrrigationRecordRepository irrigationRecordRepository;
    CropFieldRepository cropFieldRepository;
    UserService userService;

    public CropFieldServiceImpl(
            CropFieldRepository cropFieldRepository,
            UserService userService,
            IrrigationRecordRepository irrigationRecordRepository) {
        this.cropFieldRepository = cropFieldRepository;
        this.userService = userService;
        this.irrigationRecordRepository = irrigationRecordRepository;
    }

    @Override
    public CropField createCropField(Long userId, CropField cropField) {
        existsUserByUserId(userId);
        cropField.setUser(userService.getUserById(userId));
        validateCropField(cropField);
        return cropFieldRepository.save(cropField);
    }

    @Override
    public CropField getCropFieldById(Long cropFieldId) {
        existsCropFieldByCropFieldId(cropFieldId);
        return cropFieldRepository.findById(cropFieldId).orElseThrow(() -> new ResourceNotFoundException("CropField not found"));
    }

    @Override
    public CropField updateCropField(CropField cropField) {
        existsCropFieldByCropFieldId(cropField.getId());
        validateCropField(cropField);
        return cropFieldRepository.save(cropField);
    }

    @Override
    public CropField startIrrigation(Long cropFieldId) {
        CropField cropField = getCropFieldById(cropFieldId);
        cropField.setIrrigationStartTime(LocalTime.now());
        return cropFieldRepository.save(cropField);
    }

    @Override
    public CropField completeIrrigation(Long cropFieldId) {
        CropField cropField = getCropFieldById(cropFieldId);
        cropField.setIrrigationEndTime(LocalTime.now());
        cropField.setIrrigationCompleted(true);
        if (cropField.getIrrigationStartTime() != null && cropField.getIrrigationEndTime() != null) {
            long duration = ChronoUnit.MINUTES.between(cropField.getIrrigationStartTime(), cropField.getIrrigationEndTime());
            cropField.setIrrigationDuration(duration);
        } else {
            throw new IllegalArgumentException("Irrigation start time or end time is null");
        }
        IrrigationRecord irrigationRecord = IrrigationRecord.builder()
                .cropField(cropField)
                .irrigationDate(LocalDate.now())
                .duration(cropField.getIrrigationDuration())
                .startTime(cropField.getIrrigationStartTime())
                .endTime(cropField.getIrrigationEndTime())
                .build();
        irrigationRecordRepository.save(irrigationRecord);
        return cropFieldRepository.save(cropField);
    }


    @Override
    public void deleteCropField(Long cropFieldId) {
        existsCropFieldByCropFieldId(cropFieldId);
        cropFieldRepository.deleteById(cropFieldId);
    }

    @Override
    public List<CropField> getAllCropFields() {
        return cropFieldRepository.findAll();
    }

    private void existsCropFieldByCropFieldId(Long cropFieldId) {
        if (!cropFieldRepository.existsById(cropFieldId)) {
            throw new ResourceNotFoundException("CropField not found");
        }
    }

    private void existsUserByUserId(Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new ResourceNotFoundException("No existe el usuario con el id: " + userId);
        }
    }

    private void validateCropField(CropField cropField) {
        if (cropField.getName() == null || cropField.getName().isEmpty()) {
            throw new ResourceNotFoundException("El nombre del campo no puede estar vacío");
        }
        if (cropField.getCropPlant() == null || cropField.getCropPlant().isEmpty()) {
            throw new ResourceNotFoundException("El cultivo no puede estar vacío");
        }
        if (cropField.getSoilType() == null || cropField.getSoilType().isEmpty()) {
            throw new ResourceNotFoundException("El tipo de suelo no puede estar vacío");
        }


    }
}
