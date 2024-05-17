package com.upc.smartsproutbackend.service.impl;

import com.upc.smartsproutbackend.models.IrrigationRecord;
import com.upc.smartsproutbackend.repository.IrrigationRecordRepository;
import com.upc.smartsproutbackend.service.IrrigationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IrrigationRecordServiceImpl implements IrrigationRecordService {
    @Autowired
    private IrrigationRecordRepository irrigationRecordRepository;

    @Override
    public void deleteIrrigationRecord(Long irrigationRecordId) {
        irrigationRecordRepository.deleteById(irrigationRecordId);
    }

    @Override
    public IrrigationRecord getIrrigationRecordById(Long irrigationRecordId) {
        return irrigationRecordRepository.findById(irrigationRecordId).orElse(null);
    }

    @Override
    public List<IrrigationRecord> getAllIrrigationRecords() {
        return irrigationRecordRepository.findAll();
    }

    @Override
    public List<IrrigationRecord> getIrrigationByBetweenDates(LocalDate startDate, LocalDate endDate) {
        return irrigationRecordRepository.findByIrrigationDateBetween(startDate, endDate);
    }
}
