package com.br.luminous.service;

import com.br.luminous.entity.Consumption;
import com.br.luminous.entity.Device;
import com.br.luminous.entity.EnergyBill;
import com.br.luminous.models.TrackResponse;
import com.br.luminous.repository.ConsumptionRepository;
import com.br.luminous.repository.DeviceRepository;
import com.br.luminous.repository.EnergyBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@EnableScheduling
public class ConsumptionTrackService {

    private DeviceRepository deviceRepository;
    private ConsumptionRepository consumptionRepository;

    private EnergyBillRepository energyBillRepository;

    @Scheduled(fixedRate = 30000)
    private void updateConsumptions (){
        List<Device> devices = new ArrayList<>();
        deviceRepository.findAll().forEach(devices::add);

        devices.forEach(d -> consumptionRepository.save(new Consumption(calculateEnergyConsumptioKwh(d), d)));
        System.out.println("foi");
    }

    public TrackResponse getCurrentConsumptionOfAddress(Long addressId){
        double consKWh = consumptionRepository.getCurrentConsumption(addressId).get(0).getEnergyConsumptionKWh();
        double consReais = consumptionRepository.getCurrentConsumption(addressId).get(0).getEnergyConsumptionReais();

        List<EnergyBill> energyBills = energyBillRepository.findAllEnergyBillByAddress(addressId);
        if(energyBills.isEmpty()){
            return new TrackResponse(consKWh, consReais, LocalDate.now(), null);
        }
        return new TrackResponse(consKWh, consReais, LocalDate.now(), energyBills.get(energyBills.size() -1));
    }

    private double calculateEnergyConsumptioKwh(Device d){
        return (d.getPower()/1000) * (d.getUsageTime().getHour() + (d.getUsageTime().getMinute()/0.6)/100);
    }
}
