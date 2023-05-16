package com.br.luminous.service;


import com.br.luminous.models.AddressRequest;
import com.br.luminous.models.AddressResponse;
import com.br.luminous.entity.Address;
import com.br.luminous.entity.User;
import com.br.luminous.exceptions.AddressNotFoundException;
import com.br.luminous.mapper.AddressRequestToEntity;
import com.br.luminous.repository.AddressRepository;
import com.br.luminous.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;
    private AddressRequestToEntity addressRequestToEntity;
    private UserRepository userRepository;
    private UserService userService;

    public Long create(Long userId, AddressRequest addressRequest){
        var address = addressRequestToEntity.mapper(addressRequest);
        var user = updateUserAddresses(userId, address);
        address.setUser(user);
        var savedAddress = addressRepository.save(address);
        userRepository.save(user);
        return savedAddress.getId();
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

private User updateUserAddresses(Long userId, Address address) {
    User user = userService.getUserById(userId);
    var addresses = user.getAddresses();
    addresses.add(address);
    user.setAddresses(addresses);
    return user;
}
}


