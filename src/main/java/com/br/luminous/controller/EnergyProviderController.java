package com.br.luminous.controller;
import com.br.luminous.DTO.EnergyProviderRequest;
import com.br.luminous.DTO.EnergyProviderResponse;
import com.br.luminous.entity.EnergyProvider;
import com.br.luminous.service.EnergyProviderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/energy-provider")
public class EnergyProviderController {

    private EnergyProviderService energyProviderService;

    @RequestMapping("/{name}")
    public ResponseEntity<EnergyProviderResponse> getEnergyProviderByName(@PathVariable String name){
        EnergyProviderResponse energyProvider = energyProviderService.getEnergyProviderByName(name);
        return new ResponseEntity<EnergyProviderResponse>(energyProvider, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Long> createealEnergyProvider(@RequestBody EnergyProviderRequest energyProvider){
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
