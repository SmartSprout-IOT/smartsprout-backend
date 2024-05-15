package com.upc.smartsproutbackend.service.impl;

import com.upc.smartsproutbackend.models.CropField;
import com.upc.smartsproutbackend.models.User;
import com.upc.smartsproutbackend.repository.CropFieldRepository;
import com.upc.smartsproutbackend.service.CropFieldService;
import com.upc.smartsproutbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropFieldServiceImpl implements CropFieldService {
    CropFieldRepository cropFieldRepository;
    UserService userService;

    public CropFieldServiceImpl(
            CropFieldRepository cropFieldRepository,
            UserService userService
    ) {
        this.cropFieldRepository = cropFieldRepository;
        this.userService = userService;
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
        return cropFieldRepository.findById(cropFieldId).orElse(null);
    }

    @Override
    public CropField updateCropField(CropField cropField) {
        existsCropFieldByCropFieldId(cropField.getId());
        validateCropField(cropField);
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
            throw new RuntimeException("CropField not found");
        }
    }

    private void existsUserByUserId(Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            throw new RuntimeException("No existe el usuario con el id: " + userId);
        }
    }

    private void validateCropField(CropField cropField) {
        if (cropField.getName() == null || cropField.getName().isEmpty()) {
            throw new RuntimeException("El nombre del campo no puede estar vacío");
        }
        if (cropField.getCropPlant() == null || cropField.getCropPlant().isEmpty()) {
            throw new RuntimeException("El cultivo no puede estar vacío");
        }
        if (cropField.getSoilType() == null || cropField.getSoilType().isEmpty()) {
            throw new RuntimeException("El tipo de suelo no puede estar vacío");
        }


    }
}
