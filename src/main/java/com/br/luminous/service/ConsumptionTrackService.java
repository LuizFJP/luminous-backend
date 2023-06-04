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
    private  DeviceService deviceService;
    private ConsumptionRepository consumptionRepository;
    private EnergyBillRepository energyBillRepository;

    @Scheduled(cron = "1 0 0 * * *")
    private void updateConsumptions (){
        List<Device> devices = new ArrayList<>();
        deviceRepository.findAll().forEach(devices::add);

        devices.forEach(d -> consumptionRepository.save(new Consumption(d.getConsumptionKWh(), d)));
        System.out.println("foi");
    }

    public TrackResponse getCurrentConsumptionOfAddress(Long addressId){
            double consKWh;
            double consReais;

        try {
            consKWh = consumptionRepository.getCurrentConsumption(addressId).get(0).getEnergyConsumptionKWh();
            consReais = consumptionRepository.getCurrentConsumption(addressId).get(0).getEnergyConsumptionReais();
        }
        catch (NullPointerException e){
            consKWh = 0.0;
            consReais = 0.0;
        }

        for (Device d :deviceService.findDevicesByAddressId(addressId)) {
            consKWh += d.getConsumptionKWh();
            consReais += d.getConsumptionReais();
        }

        List<EnergyBill> energyBills = energyBillRepository.findAllEnergyBillByAddress(addressId);
        if(energyBills.isEmpty()){
            return new TrackResponse(consKWh, consReais, LocalDate.now(), null);
        }
        return new TrackResponse(consKWh, consReais, LocalDate.now(), energyBills.get(energyBills.size() -1));
    }
}
