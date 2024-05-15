package com.upc.smartsproutbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "crop_field")
public class CropField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "description", nullable = false, length = 50)
    private String description;
    @Column(name = "location", nullable = false, length = 50)
    private String location;
    @Column(name = "size", nullable = false, length = 50)
    private double size;
    @Column(name = "soil_type", nullable = false, length = 50)
    private String soilType;
    @Column(name = "crop_type", nullable = false, length = 50)
    private String cropType;
    @Column(name = "crop_variety", nullable = false, length = 50)
    private String cropVariety;
    @Column(name = "crop_plant", nullable = false, length = 50)
    private String cropPlant;
    @Column(name = "planting_date", nullable = false, length = 50)
    private LocalDate plantingDate;
    @Column(name = "ideal_temperature", nullable = false, length = 50)
    private String ideal_temperature;
    @Column(name = "ideal_humidity", nullable = false, length = 50)
    private String ideal_humidity;
    @Column(name = "irrigation_duration", nullable = false, length = 50)
    private int irrigationDuration;
    @Column(name = "irrigation_starttime", nullable = false, length = 50)
    private LocalTime irrigationStartTime;
    @Column(name = "irrigation_endtime", nullable = false, length = 50)
    private LocalTime irrigationEndTime;
    @Column(name = "irrigation_completed", nullable = false)
    private boolean irrigationCompleted;

    @JsonIgnore
    @OneToMany(mappedBy = "cropField", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IrrigationRecord> irrigationRecords;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "FK_USER_CROP_FIELD_ID"))
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

}
