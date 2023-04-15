package com.br.luminous.controller;

import com.br.luminous.entity.Address;
import com.br.luminous.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/address")
public class AddressController {

    private AddressService addressService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<String> teste() {
        return new ResponseEntity<String>("Deu certo", HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Long> createAddress(@RequestBody Address address){
        Long id = addressService.create(address);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

}