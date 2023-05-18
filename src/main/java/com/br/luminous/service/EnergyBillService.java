package com.br.luminous.service;

import com.br.luminous.entity.EnergyBill;
import com.br.luminous.exceptions.EnergyBillNotFoundException;
import com.br.luminous.repository.EnergyBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class EnergyBillService {
    private EnergyBillRepository energyBillRepository;

    public Long create(EnergyBill energyBill) {
        EnergyBill response = energyBillRepository.save(energyBill);
        return response.getId();
    }

    public EnergyBill getBill(Long id) {
        Optional<EnergyBill> response = energyBillRepository.findById(id);
        return response.orElseThrow(EnergyBillNotFoundException::new);
    }
    public List<EnergyBill> getAllEnergyBills(){
        return StreamSupport.stream(energyBillRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
