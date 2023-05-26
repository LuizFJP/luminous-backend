package com.br.luminous.service;

import com.br.luminous.entity.ConsumptionAlert;
import com.br.luminous.exceptions.ConsumptionAlertNotFound;
import com.br.luminous.mapper.ConsumptionAlertRequestToEntity;
import com.br.luminous.models.ConsumptionAlertRequest;
import com.br.luminous.repository.ConsumptionAlertRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsumptionAlertService {

    private ConsumptionAlertRepository consumptionAlertRepository;
    private AddressService addressService;
    private ConsumptionAlertRequestToEntity consumptionAlertRequestToEntity;

    public Long create(Long address_id, ConsumptionAlertRequest consumptionAlertRequest){
        try {
            var address = addressService.getAddressById(address_id);
            var consumptionAlert = consumptionAlertRequestToEntity.mapper(consumptionAlertRequest);
            consumptionAlert.setAddress(address);
            var consumptionAlertsList = address.getConsumptionAlerts();
            consumptionAlertsList.add(consumptionAlert);
            address.setConsumptionAlerts(consumptionAlertsList);
            var consumptionAlertPersisted = consumptionAlertRepository.save(consumptionAlert);
            return consumptionAlertPersisted.getId();
        }catch(Exception e){
            throw e;
        }
    }
    public ConsumptionAlert get(Long id){
        var response = consumptionAlertRepository.findById(id);
        return response.orElseThrow(ConsumptionAlertNotFound::new);
    }
    public ConsumptionAlert update(Long id, ConsumptionAlertRequest consumptionAlertRequest){
        try {
            var consumptionAlertToUpdate = consumptionAlertRepository.findById(id).get();
            consumptionAlertToUpdate.setConsumptionLimit(consumptionAlertRequest.getConsumptionLimit());
            consumptionAlertToUpdate.setDescricao(consumptionAlertRequest.getDescription());
            var response = consumptionAlertRepository.save(consumptionAlertToUpdate);
            return response;
        }catch(ConsumptionAlertNotFound e){
            throw e;
        }
    }
    public List<ConsumptionAlert> getAll(Long address_id){
        var address = addressService.getAddressById(address_id);
        var consumptionAlertList = address.getConsumptionAlerts();
        return consumptionAlertList;
    }
    public void delete(Long consumptionAlert_id){
        try{
            var consumptionAlertToDelete = get(consumptionAlert_id);
            consumptionAlertRepository.delete(consumptionAlertToDelete);
        }catch(ConsumptionAlertNotFound e){
            throw e;
        }
    }
}
