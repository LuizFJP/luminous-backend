package com.br.luminous.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DealershipRequest {
    private String name;

    private String urlMantain;

    private String urlEnergyFall;
}
