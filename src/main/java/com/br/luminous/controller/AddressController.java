package com.br.luminous.controller;

import com.br.luminous.DTO.AddressResponse;
import com.br.luminous.entity.Address;
import com.br.luminous.models.AddressRequest;
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

    @RequestMapping("/{id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable Long id){
        AddressResponse address = addressService.get(id);
        return new ResponseEntity<AddressResponse>(address, HttpStatus.OK);
    }

   @PostMapping
    public ResponseEntity<Long> createAddress(@RequestBody AddressRequest address){
        Long id = addressService.create(address);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> updateAddress(@PathVariable Long id, @RequestBody AddressRequest address) {
        addressService.update(id, address);
        return new ResponseEntity(address, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAddress(@PathVariable Long id) {
        addressService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
