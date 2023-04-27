package com.br.luminous.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressRequest {
    private String city;
    private String cep;
    private int houseNumber;
    private int inputVoltage;
}
