package com.br.luminous.service;


import com.br.luminous.models.AddressRequest;
import com.br.luminous.models.AddressResponse;
import com.br.luminous.entity.Address;
import com.br.luminous.entity.User;
import com.br.luminous.exceptions.AddressNotFoundException;
import com.br.luminous.mapper.AddressRequestToEntity;
import com.br.luminous.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;
    private AddressRequestToEntity addressRequestToEntity;
    private UserService userService;

    public Long create(AddressRequest address){
       var addressEntity = addressRequestToEntity.mapper(address);
       Address response = addressRepository.save(addressEntity);
        return response.getId();
    }

    public Address addAdress(Long id, Address address) {
        User user = userService.getUserById(id);
        address.setUser(user);
        return addressRepository.save(address);
    }

    public Address getAddressById(Long id){
        Optional<Address> address = addressRepository.findById(id);
        return address.orElseThrow(AddressNotFoundException::new);
    }


    public AddressResponse get(Long id) {
        try {
            var address = getAddressById(id);
            var addressResponse = new AddressResponse();
            BeanUtils.copyProperties(address, addressResponse);
            return addressResponse;
        } catch (RuntimeException notFoundException) {
            throw new AddressNotFoundException();
        }
    }


    public AddressResponse update(Long id, AddressRequest addressRequest) {
        try {
            Address address = getAddressById(id);
            BeanUtils.copyProperties(addressRequest, address);
            address.setCity(addressRequest.getCity());
            address.setCep(addressRequest.getCep());
            address.setHouseNumber(addressRequest.getHouseNumber());
            address.setInputVoltage(addressRequest.getInputVoltage());
            addressRepository.save(address);
            var addressResponse = new AddressResponse();
            BeanUtils.copyProperties(address, addressResponse);
            return addressResponse;
        } catch (RuntimeException notFoundException) {
            throw new AddressNotFoundException();
        }
    }

    public void delete(Long id) {
        try {
            getAddressById(id);
            addressRepository.deleteById(id);
        } catch (RuntimeException notFoundException) {
            throw new AddressNotFoundException();
        }

    }


}


