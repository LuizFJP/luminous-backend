package com.br.luminous.service;

import com.br.luminous.entity.EnergyBill;
import com.br.luminous.exceptions.EnergyBillNotFoundException;
import com.br.luminous.repository.EnergyBillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.nio.file.Paths;

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
        return energyBillRepository.findAll();
    }

    private String generateUniqueFileName(String originalFileName){
        LocalDateTime dateNow = LocalDateTime.now();
        String newFileName = originalFileName + dateNow;
        return newFileName;
    }
}
