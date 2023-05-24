package com.br.luminous.mapper;

import com.br.luminous.entity.EnergyBill;
import com.br.luminous.models.EnergyBillRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EnergyBillRequestToEntity {
    public EnergyBill mapper(EnergyBillRequest energyBillRequest){
        EnergyBill energyBill = new EnergyBill();
        BeanUtils.copyProperties(energyBillRequest, energyBill);
        return energyBill;
    }
}
