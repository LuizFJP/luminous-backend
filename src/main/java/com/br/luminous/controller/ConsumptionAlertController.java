package com.br.luminous.controller;

import com.br.luminous.entity.ConsumptionAlert;
import com.br.luminous.models.ConsumptionAlertRequest;
import com.br.luminous.service.ConsumptionAlertService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/consumption-alert")
public class ConsumptionAlertController {
    ConsumptionAlertService consumptionAlertService;
    @PostMapping("/user/{id}")
    public ResponseEntity<Long> create(@PathVariable Long id, @RequestBody ConsumptionAlertRequest consumptionAlertRequest){
            Long consumptionAlertId = consumptionAlertService.create(id, consumptionAlertRequest);
            return new ResponseEntity<>(consumptionAlertId, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ConsumptionAlert> update(@PathVariable Long id, @RequestBody ConsumptionAlertRequest consumptionAlertRequest){
        var response = consumptionAlertService.update(id, consumptionAlertRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ConsumptionAlert> delete(@PathVariable Long id){
        consumptionAlertService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ConsumptionAlert> getConsumptionAlert(@PathVariable Long id){
        var response = consumptionAlertService.get(id);
        if(response != null){
            return new ResponseEntity<ConsumptionAlert>(response, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/getAll/user/{id}")
    public ResponseEntity<List<ConsumptionAlert>> getAll(@PathVariable Long id){
        var response = consumptionAlertService.getAll(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
