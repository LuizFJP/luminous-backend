package com.br.luminous.controller;

import com.br.luminous.service.EnergyBillService;
import com.br.luminous.entity.EnergyBill;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/energyBill")
public class EnergyBillController {
    private EnergyBillService energyBillService;

    @GetMapping("/{id}")
    public ResponseEntity<EnergyBill> getEnergyBillById(@PathVariable Long id){
        EnergyBill energyBill = energyBillService.getBill(id);
        return new ResponseEntity<EnergyBill>(energyBill, HttpStatus.OK);
    }
        @PostMapping("/")
    public ResponseEntity<Long> createEnergyBill(@RequestBody EnergyBill energybill){
            Long id = energyBillService.create(energybill);
            return new ResponseEntity<Long>(id, HttpStatus.CREATED);
        }
}
