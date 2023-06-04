package com.br.luminous.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {
    private String city;
    private String cep;
    private int houseNumber;
    private int inputVoltage;
    private String street;
    private String neighborhood;
    private Long energyProviderId;
    private String state;
    private String nickname;
    private boolean mainAddress;
}
