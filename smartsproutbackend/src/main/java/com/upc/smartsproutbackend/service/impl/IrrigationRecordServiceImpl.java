package com.upc.smartsproutbackend.service.impl;

import com.upc.smartsproutbackend.models.IrrigationRecord;
import com.upc.smartsproutbackend.repository.CropFieldRepository;
import com.upc.smartsproutbackend.repository.IrrigationRecordRepository;
import com.upc.smartsproutbackend.service.IrrigationRecordService;
import com.upc.smartsproutbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IrrigationRecordServiceImpl implements IrrigationRecordService {
    CropFieldRepository cropFieldRepository;
    UserService userService;
    @Autowired
    private IrrigationRecordRepository irrigationRecordRepository;

    @Override
    public IrrigationRecord createIrrigationRecord(IrrigationRecord irrigationRecord, Long cropFieldId) {
        irrigationRecord.setCropField(cropFieldRepository.findById(cropFieldId).orElse(null));
        return irrigationRecordRepository.save(irrigationRecord);
    }

    @Override
    public void deleteIrrigationRecord(Long irrigationRecordId) {
        irrigationRecordRepository.deleteById(irrigationRecordId);
    }

    @Override
    public IrrigationRecord getIrrigationRecordById(Long irrigationRecordId) {
        return irrigationRecordRepository.findById(irrigationRecordId).orElse(null);
    }

    @Override
    public List<IrrigationRecord> getAllIrrigationRecordsByCropFieldId(Long cropFieldId) {
        return irrigationRecordRepository.findByCropFieldId(cropFieldId);
    }


    @Override
    public List<IrrigationRecord> getIrrigationByBetweenDatesAndCropFieldId(LocalDate startDate, LocalDate endDate, Long cropFieldId) {
        return irrigationRecordRepository.findByIrrigationDateBetweenAndCropFieldId(startDate, endDate, cropFieldId);
    }


}
