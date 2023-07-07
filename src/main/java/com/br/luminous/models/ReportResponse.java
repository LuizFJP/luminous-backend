package com.br.luminous.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponse {

    private double energyConsumptionKWh;
    private double energyConsumptionReais;
    private LocalDateTime period;
    private String name;

}
