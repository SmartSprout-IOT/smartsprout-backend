package com.upc.smartsproutbackend.service;

import com.upc.smartsproutbackend.models.CropField;

public interface CropFieldService {
    CropField createCropField(Long userId, CropField cropField);
    CropField getCropFieldById(Long cropFieldId);
    CropField updateCropField(CropField cropField);
    void deleteCropField(Long cropFieldId);
}
