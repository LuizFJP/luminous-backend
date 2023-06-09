package com.br.luminous.controller;

import com.br.luminous.models.TrackResponse;
import com.br.luminous.service.ConsumptionTrackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/consumptionTrack")
public class ConsumptionTrackController {

    private ConsumptionTrackService service;

@GetMapping("/address/{addressId}")
    public ResponseEntity<TrackResponse> getCurrentConsumption(@PathVariable Long addressId){
    TrackResponse response = service.getCurrentConsumptionOfAddress(addressId);
    return new ResponseEntity (response, HttpStatus.OK);
    }
}
