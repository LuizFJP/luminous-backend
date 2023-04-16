package com.br.luminous.service;

import com.br.luminous.entity.EnergyBill;
import com.br.luminous.exceptions.EnergyBillNotFoundException;
import com.br.luminous.repository.EnergyBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EnergyBillService {
    private EnergyBillRepository energyBillRepository;
    public Long create(EnergyBill energyBill){
        EnergyBill response = energyBillRepository.save(energyBill);
        return response.getId();
    }
    public EnergyBill getBill(Long id){
        Optional<EnergyBill> response = energyBillRepository.findById(id);
        return response.orElseThrow(EnergyBillNotFoundException::new);
    }

    @SpringBootApplication
    @EntityScan
    public static class LuminousApplication {

        public static void main(String[] args) {
            SpringApplication.run(LuminousApplication.class, args);
        }

        }
}
