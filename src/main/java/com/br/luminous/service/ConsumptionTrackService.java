package com.br.luminous.service;

import com.br.luminous.entity.Address;
import com.br.luminous.repository.ConsumptionRepository;
import com.br.luminous.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@EnableScheduling
public class ConsumptionTrackService {

    private DeviceRepository deviceRepository;
    private ConsumptionRepository consumptionRepository;
    private DeviceService deviceService;
    private AddressService addressService;

    @Scheduled
    private void updateConsumptions (Long addressId){

    }

}
