package com.br.luminous.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;


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
    @JsonBackReference
    private Address address;

}
