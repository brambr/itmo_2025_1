package ru.javaadvance.containertracer.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import ru.javaadvance.containertracer.validators.DamageLocationVal;
import ru.javaadvance.containertracer.validators.DamageRepairTimeVal;

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
    @DamageLocationVal(message = "Location code has wrong format")
    private Integer location;
    @Column(name = "size_in_cm")
    private Integer sizeInCm;
    @Column(name = "repair_number")
    private  String repairNumber;
    @Column(name = "repair_date")
    @DamageRepairTimeVal(message = "Дата ремонта находиться в будущем")
    private LocalDate repairDate;
    @Column(name = "add_date")
    private LocalDate addDate;
    private Long cntrPassId;


}
