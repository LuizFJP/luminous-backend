package com.br.luminous.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnergyBillRequest {
    private LocalDate referenceDate;
    private LocalDate dueDate;
    private Double energyConsumptionReais;
    private Double energyConsumption_kWh;
}
