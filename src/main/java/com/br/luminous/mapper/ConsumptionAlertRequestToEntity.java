package com.br.luminous.mapper;

import com.br.luminous.entity.ConsumptionAlert;
import com.br.luminous.entity.EnergyBill;
import com.br.luminous.models.ConsumptionAlertRequest;
import com.br.luminous.models.EnergyBillRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConsumptionAlertRequestToEntity {
    public ConsumptionAlert mapper(ConsumptionAlertRequest consumptionAlertRequest){
        ConsumptionAlert consumptionAlert = new ConsumptionAlert();
        BeanUtils.copyProperties(consumptionAlertRequest, consumptionAlert);
        return consumptionAlert;
    }
}
