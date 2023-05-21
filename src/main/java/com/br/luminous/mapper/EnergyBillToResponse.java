package com.br.luminous.mapper;

import com.br.luminous.entity.EnergyBill;
import com.br.luminous.models.EnergyBillResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EnergyBillToResponse {
    public EnergyBillResponse mapper(EnergyBill energyBill){
        EnergyBillResponse energyBillResponse = new EnergyBillResponse();
        BeanUtils.copyProperties(energyBill, energyBillResponse);
        return energyBillResponse;
    }
}
