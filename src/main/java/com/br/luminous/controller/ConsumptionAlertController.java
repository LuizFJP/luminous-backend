package com.br.luminous.controller;

import com.br.luminous.entity.ConsumptionAlert;
import com.br.luminous.exceptions.AddressNotFoundException;
import com.br.luminous.exceptions.ConsumptionAlertNotFound;
import com.br.luminous.exceptions.UserNotFoundException;
import com.br.luminous.models.ConsumptionAlertRequest;
import com.br.luminous.service.ConsumptionAlertService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/consumption-alert")
public class ConsumptionAlertController {
    private final ConsumptionAlertService consumptionAlertService;

    @PostMapping("/address/{id}")
    public ResponseEntity<Long> create(@PathVariable Long id, @RequestBody ConsumptionAlertRequest consumptionAlertRequest) {
        try {
            Long consumptionAlertId = consumptionAlertService.create(id, consumptionAlertRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(consumptionAlertId);
        } catch (AddressNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumptionAlert> update(@PathVariable Long id, @RequestBody ConsumptionAlertRequest consumptionAlertRequest) {
        try {
            ConsumptionAlert updatedAlert = consumptionAlertService.update(id, consumptionAlertRequest);
            return ResponseEntity.ok(updatedAlert);
        } catch (ConsumptionAlertNotFound exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            consumptionAlertService.delete(id);
            return ResponseEntity.ok().build();
        } catch (ConsumptionAlertNotFound exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumptionAlert> get(@PathVariable Long id) {
        try {
            ConsumptionAlert response = consumptionAlertService.get(id);
            return ResponseEntity.ok(response);
        } catch (ConsumptionAlertNotFound exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/getAll/address/{id}")
    public ResponseEntity<List<ConsumptionAlert>> getAll(@PathVariable Long id) {
        try {
            List<ConsumptionAlert> response = consumptionAlertService.getAll(id);
            return ResponseEntity.ok(response);
        } catch (UserNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
