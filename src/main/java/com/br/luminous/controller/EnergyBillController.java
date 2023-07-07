package com.br.luminous.controller;

import com.br.luminous.exceptions.AddressNotFoundException;
import com.br.luminous.exceptions.BillFileNotFoundException;
import com.br.luminous.exceptions.EnergyBillNotFoundException;
import com.br.luminous.models.EnergyBillRequest;
import com.br.luminous.models.EnergyBillResponse;
import com.br.luminous.service.EnergyBillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/energyBill")
public class EnergyBillController {
    private EnergyBillService energyBillService;

    @GetMapping("/{id}")
    public ResponseEntity<EnergyBillResponse> getEnergyBillById(@PathVariable Long id) {
        try {
            EnergyBillResponse energyBillResponse = energyBillService.getById(id);
            return ResponseEntity.ok(energyBillResponse);
        } catch (EnergyBillNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/address/{address_id}/billFile/{billFile_id}")
    public ResponseEntity<Long> createEnergyBill(@PathVariable Long address_id, @PathVariable Long billFile_id, @RequestBody EnergyBillRequest energyBillRequest) {
        try {
            Long id = energyBillService.create(address_id, billFile_id, energyBillRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (AddressNotFoundException | BillFileNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getAll/{address_id}")
    public ResponseEntity<List<EnergyBillResponse>> getAll(@PathVariable Long address_id) {
        try {
            List<EnergyBillResponse> response = energyBillService.getAll(address_id);
            return ResponseEntity.ok(response);
        } catch (AddressNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnergyBillResponse> update(@PathVariable Long id, @RequestBody EnergyBillRequest energyBillRequest) {
        try {
            EnergyBillResponse response = energyBillService.update(id, energyBillRequest);
            return ResponseEntity.ok(response);
        } catch (EnergyBillNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            energyBillService.delete(id);
            return ResponseEntity.ok().build();
        } catch (EnergyBillNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
