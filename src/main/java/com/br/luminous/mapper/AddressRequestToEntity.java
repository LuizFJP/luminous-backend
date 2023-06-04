package com.br.luminous.mapper;

import com.br.luminous.entity.Address;
import com.br.luminous.models.AddressRequest;
import com.br.luminous.service.EnergyProviderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressRequestToEntity {

    private EnergyProviderService energyProviderService;
    public Address mapper (AddressRequest addressRequest){
        var address = new Address();

        BeanUtils.copyProperties(addressRequest, address);
        address.setEnergyProvider(energyProviderService.getEnergyProviderById(addressRequest.getEnergyProviderId()));
        return address;
    }
}
