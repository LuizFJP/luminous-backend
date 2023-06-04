package com.br.luminous.models;

import com.br.luminous.entity.EnergyBill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackResponse {
    private double energyConsumptionKWh;
    private double energyConsumptionReais;
    private LocalDate period;
    private EnergyBill lastEnergyBill;
}
