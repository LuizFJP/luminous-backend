package com.br.luminous.service;

import com.br.luminous.controller.ConsumptionAlertController;
import com.br.luminous.entity.ConsumptionAlert;
import com.br.luminous.exceptions.ConsumptionAlertNotFound;
import com.br.luminous.exceptions.UserNotFoundException;
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

    public Long create(Long user_id, ConsumptionAlert consumptionAlert){
        try {
            var user = userService.getUserById(user_id);
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
    public ConsumptionAlert update(Long id, ConsumptionAlert consumptionAlert){
        var consumptionAlertToUpdate = consumptionAlertRepository.findById(id).get();
        consumptionAlertToUpdate.setConsumptionLimit(consumptionAlert.getConsumptionLimit());
        consumptionAlertToUpdate.setDescricao(consumptionAlert.getDescricao());
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
