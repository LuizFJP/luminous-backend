package com.br.luminous.DTO;

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
