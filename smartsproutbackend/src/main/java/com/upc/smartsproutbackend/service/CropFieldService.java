package com.upc.smartsproutbackend.service;

import com.upc.smartsproutbackend.models.CropField;

import java.util.List;

public interface CropFieldService {
    public abstract CropField createCropField(Long userId, CropField cropField);
    public abstract CropField getCropFieldById(Long cropFieldId);
    public abstract CropField updateCropField(CropField cropField);
    public abstract void deleteCropField(Long cropFieldId);
    public abstract List<CropField> getAllCropFields();
}
