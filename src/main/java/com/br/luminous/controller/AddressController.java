package com.br.luminous.controller;

import com.br.luminous.entity.Address;
import com.br.luminous.models.AddressRequest;
import com.br.luminous.models.AddressResponse;
import com.br.luminous.repository.AddressRepository;
import com.br.luminous.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/address")
public class AddressController {

    private AddressService addressService;
    private AddressRepository addressRepository;


    @GetMapping("/user/{userId}/addresses")
    public List<Address> getAddressesOfUser(@PathVariable Long userId) {
        return addressService.getAddressByUserId(userId);
    }


    @PostMapping("/user/{id}")
    public ResponseEntity<Long> createAddress(@PathVariable Long id, @RequestBody AddressRequest address){
        Long response = addressService.create(id, address);
        return new ResponseEntity<Long>(response, HttpStatus.CREATED);
    }

    @PutMapping("/user/{userId}/addresses/{id}")
    public ResponseEntity<AddressResponse> updateAddressesOfUser(@PathVariable Long userId, @PathVariable Long id, @RequestBody AddressRequest address) {
        addressService.update(userId, id, address);
        return new ResponseEntity(address, HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}/addresses/{id}")
    public ResponseEntity<AddressResponse> deleteAddressesOfUser(@PathVariable Long userId, @PathVariable Long id) {
        addressService.delete(userId, id);
        return new ResponseEntity(HttpStatus.OK);
    }

}