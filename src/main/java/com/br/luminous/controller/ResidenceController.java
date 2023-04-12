package com.br.luminous.controller;

import com.br.luminous.entity.Residence;
import com.br.luminous.service.ResidenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/residence")
public class ResidenceController {

    private ResidenceService residenceService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<String> teste() {
        return new ResponseEntity<String>("Deu certo", HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Long> createResidence(@RequestBody Residence residence){
        Long id = residenceService.create(residence);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

}
