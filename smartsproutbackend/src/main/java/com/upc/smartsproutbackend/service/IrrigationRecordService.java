package com.upc.smartsproutbackend.service;

public interface IrrigationRecordService {
public abstract void createIrrigationRecord(Long cropFieldId, Long irrigationRecordId);
    public abstract void deleteIrrigationRecord(Long irrigationRecordId);
    public abstract void updateIrrigationRecord(Long irrigationRecordId);
    public abstract void getIrrigationRecordById(Long irrigationRecordId);
    public abstract void getAllIrrigationRecords();
}
