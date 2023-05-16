package com.br.luminous.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnergyProviderResponse {
    private String name;

    private String urlMantaintenance;

    private String urlEnergyFall;
}
