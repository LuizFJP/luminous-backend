package com.br.luminous.service;

import com.br.luminous.controller.ConsumptionAlertController;
import com.br.luminous.entity.ConsumptionAlert;
import com.br.luminous.exceptions.ConsumptionAlertNotFound;
import com.br.luminous.exceptions.UserNotFoundException;
import com.br.luminous.mapper.ConsumptionAlertRequestToEntity;
import com.br.luminous.models.ConsumptionAlertRequest;
import com.br.luminous.repository.ConsumptionAlertRepository;
import com.br.luminous.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ConsumptionAlertService {

    private ConsumptionAlertRepository consumptionAlertRepository;
    private UserService userService;
    private UserRepository userRepository;
    private ConsumptionAlertRequestToEntity consumptionAlertRequestToEntity;

    public Long create(Long user_id, ConsumptionAlertRequest consumptionAlertRequest){
        try {
            var user = userService.getUserById(user_id);
            var consumptionAlert = consumptionAlertRequestToEntity.mapper(consumptionAlertRequest);
            consumptionAlert.setUser(user);
            var consumptionAlertsList = user.getConsumptionAlerts();
            consumptionAlertsList.add(consumptionAlert);
            user.setConsumptionAlerts(consumptionAlertsList);
            userRepository.save(user);
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
        var consumptionAlertToUpdate = consumptionAlertRepository.findById(id).get();

        consumptionAlertToUpdate.setConsumptionLimit(consumptionAlertRequest.getConsumptionLimit());
        consumptionAlertToUpdate.setDescricao(consumptionAlertRequest.getDescricao());
        var response = consumptionAlertRepository.save(consumptionAlertToUpdate);
        return response;
    }
    public List<ConsumptionAlert> getAll(Long user_id){
        var user = userService.getUserById(user_id);
        var consumptionAlertList = user.getConsumptionAlerts();
        return consumptionAlertList;
    }
    public void delete(Long consumptionAlert_id){
        try{
            consumptionAlertRepository.deleteById(consumptionAlert_id);
        }catch(ConsumptionAlertNotFound e){
            throw e;
        }
    }
}
