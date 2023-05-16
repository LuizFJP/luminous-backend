package com.br.luminous.controller;

import com.br.luminous.entity.EnergyProvider;
import com.br.luminous.mapper.EnergyProvReqToEnergyProvEnt;
import com.br.luminous.models.EnergyProviderRequest;
import com.br.luminous.models.EnergyProviderResponse;
import com.br.luminous.service.EnergyProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/energy-provider")
public class EnergyProviderController {

    private EnergyProviderService energyProviderService;

    @RequestMapping("/{name}")
    public ResponseEntity<EnergyProvider> getEnergyProviderByName(@PathVariable String name) {
        EnergyProvider energyProvider = energyProviderService.getEnergyProviderByName(name);
        return new ResponseEntity<EnergyProvider>(energyProvider, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Long> createEnergyProvider(@RequestBody EnergyProviderRequest energyProvider) {
        Long id = energyProviderService.create(energyProvider);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnergyProviderResponse> updateEnergyProvider(@PathVariable Long id, @RequestBody EnergyProviderRequest energyProvider) {
        energyProviderService.update(id, energyProvider);
        return new ResponseEntity(energyProvider, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEnergyProvider(@PathVariable Long id) {
        energyProviderService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
