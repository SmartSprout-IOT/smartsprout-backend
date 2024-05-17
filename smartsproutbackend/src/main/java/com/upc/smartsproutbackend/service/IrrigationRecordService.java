package com.upc.smartsproutbackend.service;

import com.upc.smartsproutbackend.models.IrrigationRecord;

import java.time.LocalDate;
import java.util.List;

public interface IrrigationRecordService {
    public abstract void deleteIrrigationRecord(Long irrigationRecordId);
    public abstract IrrigationRecord getIrrigationRecordById(Long irrigationRecordId);
    public abstract List<IrrigationRecord> getAllIrrigationRecords();
    public abstract List<IrrigationRecord> getIrrigationByBetweenDates(LocalDate startDate, LocalDate endDate);
}
