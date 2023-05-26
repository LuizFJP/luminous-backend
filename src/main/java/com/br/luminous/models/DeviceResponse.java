package com.br.luminous.models;

import com.br.luminous.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceResponse {

    private String name;
    private float power;
    private LocalTime usageTime;
    private AddressResponse addressResponse;
}
