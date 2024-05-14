package com.upc.smartsproutbackend.repository;

import com.upc.smartsproutbackend.models.IrrigationRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IrrigationRecordRepository extends JpaRepository<IrrigationRecord, Long> {
    List<IrrigationRecord> findByCropFieldId(Long cropFieldId);
    List<IrrigationRecord> findByIrrigationDateBetween(LocalDate startDate, LocalDate endDate);
    // Otros métodos según los requisitos de tu aplicación
}
