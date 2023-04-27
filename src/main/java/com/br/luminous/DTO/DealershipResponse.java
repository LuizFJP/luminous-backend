package com.br.luminous.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealershipResponse {
    private String name;

    private String urlMantain;

    private String urlEnergyFall;
}
