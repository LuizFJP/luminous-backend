package com.br.luminous.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "bills")
public class EnergyBill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate referenceMonth;
    private LocalDate dueDate;
    private Double energyConsumptionReais;
    private int energyConsumptionkWh;
    private String bufferedBill;

}
