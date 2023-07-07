package com.br.luminous.models;

import com.br.luminous.entity.Address;
import com.br.luminous.entity.BillFile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnergyBillResponse {
    private Long id;
    private LocalDate referenceDate;
    private LocalDate dueDate;
    private Double energyConsumptionReais;
    private Double energyConsumption_kWh;
    private Address address;
    private BillFile billFile;
}
