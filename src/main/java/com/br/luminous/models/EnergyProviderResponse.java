package com.br.luminous.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnergyProviderResponse {
    private String companyName;

    private String urlMaintenance;

    private String urlEnergyFall;
}
