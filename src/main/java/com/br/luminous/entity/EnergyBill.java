package com.br.luminous.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "bills")
public class EnergyBill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate referenceDate;
    private LocalDate dueDate;
    private Double energyConsumptionReais;
    private Double energyConsumptionkWh;
    private String documentBill;

}
