package com.br.luminous.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private String city;
    private String cep;
    private int houseNumber;
    private int inputVoltage;
}
