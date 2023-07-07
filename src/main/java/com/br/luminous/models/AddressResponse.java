package com.br.luminous.models;

import com.br.luminous.entity.EnergyProvider;
import com.br.luminous.models.EnergyProviderResponse;
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
    private String street;
    private String neighborhood;
    private String state;
    private String nickname;
    private boolean mainAddress;
    private UserResponse userResponse;
    private EnergyProviderResponse energyProviderResponse;
    private EnergyProvider energyProvider;
}
