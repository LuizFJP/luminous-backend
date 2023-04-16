package com.br.luminous.service;

import com.br.luminous.entity.Address;
import com.br.luminous.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;

    public Long create(Address address){
        Address response = addressRepository.save(address);
        return response.getId();
    }

}
