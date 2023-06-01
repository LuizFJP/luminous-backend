package com.br.luminous.models;

import com.br.luminous.entity.Device;
import com.br.luminous.entity.EnergyBill;
import com.br.luminous.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private String state;
    private String nickname;
    private boolean mainAddress;
}
