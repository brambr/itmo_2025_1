package ru.javaadvance.containertracer.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import ru.javaadvance.containertracer.validators.DamageLocationValidator;
import ru.javaadvance.containertracer.validators.DamageRepairTimeValidator;

import java.time.LocalDate;

@Entity
@Table(name = "damages")
@Data
public class Damage{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer code;
    private String description;
    @DamageLocationValidator(message = "Location code has wrong format")
    private Integer location;
    @Column(name = "size_in_cm")
    private Integer sizeInCm;
    @Column(name = "repair_number")
    private  String repairNumber;
    @Column(name = "repair_date")
    @DamageRepairTimeValidator(message = "Дата ремонта находиться в будущем")
    private LocalDate repairDate;
    @Column(name = "add_date")
    private LocalDate addDate;
    @Column(name = "repair_result")
    private String repairResult;
    private Long cntrPassId;



}
