package com.br.luminous.mapper;

import com.br.luminous.entity.ConsumptionAlert;
import com.br.luminous.entity.EnergyBill;
import com.br.luminous.enums.ConsumptionAlertType;
import com.br.luminous.models.ConsumptionAlertRequest;
import com.br.luminous.models.EnergyBillRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ConsumptionAlertRequestToEntity {
    public ConsumptionAlert mapper(ConsumptionAlertRequest consumptionAlertRequest){
        String consumptionAlertType = consumptionAlertRequest.getConsumptionAlertType();
        ConsumptionAlert consumptionAlert = new ConsumptionAlert();
        BeanUtils.copyProperties(consumptionAlertRequest, consumptionAlert);
        try{
            consumptionAlert.setConsumptionAlertType(ConsumptionAlertType.valueOf(consumptionAlertType.toUpperCase()));
        }catch(Exception e){
            throw new IllegalArgumentException("Invalid Consumption Alert Type (REAIS or KWH)");
        }
        return consumptionAlert;
    }
}
