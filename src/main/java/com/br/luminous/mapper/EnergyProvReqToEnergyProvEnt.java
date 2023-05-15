package com.br.luminous.mapper;

import com.br.luminous.entity.EnergyProvider;
import com.br.luminous.models.EnergyProviderRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EnergyProvReqToEnergyProvEnt {
    public EnergyProvider mapper(EnergyProviderRequest energyProviderRequest) {
        var energyProvider = new EnergyProvider();
        BeanUtils.copyProperties(energyProvider, energyProviderRequest);
        return energyProvider;
    }
}
