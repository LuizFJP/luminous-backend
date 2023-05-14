package com.br.luminous.entity;

import lombok.Data;
import org.springframework.lang.Nullable;

import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "energy_bill")
public class EnergyBill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate referenceDate;
    private LocalDate dueDate;
    private Double energyConsumptionReais;
    private Double energyConsumption_kWh;
    private String documentBillPath;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = true)
    private Address address;

}
