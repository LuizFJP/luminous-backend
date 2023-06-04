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

    @GetMapping("/user/{userId}")
    public List<Address> getAddressesOfUser(@PathVariable Long userId) {
        return addressService.getAddressByUserId(userId);
    }


    @PostMapping("/user/{id}")
    public ResponseEntity<Long> createAddress(@PathVariable Long id, @RequestBody AddressRequest address){
        Long response = addressService.create(id, address);
        return new ResponseEntity<Long>(response, HttpStatus.CREATED);
    }

    @PutMapping("{id}/user/{userId}")
    public ResponseEntity<AddressResponse> updateAddressesOfUser(@PathVariable Long userId, @PathVariable Long id, @RequestBody AddressRequest address) {
        addressService.update(userId, id, address);
        return new ResponseEntity(address, HttpStatus.OK);
    }

    @DeleteMapping("{id}/user/{userId}")
    public ResponseEntity<AddressResponse> deleteAddressesOfUser(@PathVariable Long userId, @PathVariable Long id) {
        addressService.delete(userId, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/main")
    public Address getMainAddress(@PathVariable Long userId){
        return addressService.getMainAddress(userId);
    }

}