package com.br.luminous.service;

import com.br.luminous.entity.ConsumptionAlert;
import com.br.luminous.exceptions.UserNotFoundException;
import com.br.luminous.repository.ConsumptionAlertRepository;
import com.br.luminous.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsumptionAlertService {

    private ConsumptionAlertRepository consumptionAlertRepository;
    private UserRepository userRepository;

    public Long create(Long user_id, ConsumptionAlert consumptionAlert){
        try {
            var user = userRepository.findById(user_id).get();
            var consumptionAlertsList = user.getConsumptionAlerts();
            consumptionAlertsList.add(consumptionAlert);
            user.setConsumptionAlerts(consumptionAlertsList);
            userRepository.save(user);
            var consumptionAlertPersisted = consumptionAlertRepository.save(consumptionAlert);
            return consumptionAlertPersisted.getId();
        }catch(UserNotFoundException e){
            throw e;
        }
    }
}
