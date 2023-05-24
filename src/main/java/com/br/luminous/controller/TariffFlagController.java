package com.br.luminous.controller;

import com.br.luminous.models.TariffFlagResponse;
import com.br.luminous.service.TariffFlagService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/tariffFlag")
public class TariffFlagController {

    private TariffFlagService tariffFlagService;

    @GetMapping("/current")
    public ResponseEntity<TariffFlagResponse> getCurrentTariffFlag(){
        TariffFlagResponse response = tariffFlagService.getCurrentTariffFlag();
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
