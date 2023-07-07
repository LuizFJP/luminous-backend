package com.br.luminous.service;

import com.br.luminous.entity.EnergyBill;
import com.br.luminous.entity.EnergyProvider;
import com.br.luminous.exceptions.UserNotFoundException;
import com.br.luminous.models.AddressRequest;
import com.br.luminous.models.AddressResponse;
import com.br.luminous.entity.Address;
import com.br.luminous.entity.User;
import com.br.luminous.exceptions.AddressNotFoundException;
import com.br.luminous.mapper.AddressRequestToEntity;
import com.br.luminous.repository.AddressRepository;
import com.br.luminous.repository.EnergyBillRepository;
import com.br.luminous.repository.EnergyProviderRepository;
import com.br.luminous.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository addressRepository;
    private AddressRequestToEntity addressRequestToEntity;
    private UserRepository userRepository;
    private UserService userService;
    private EnergyProviderRepository energyProviderRepository;

    public Long create(Long userId, AddressRequest addressRequest){
        var address = addressRequestToEntity.mapper(addressRequest);
        var user = updateUserAddresses(userId, address);
        EnergyProvider energyProvider= energyProviderRepository.getById(addressRequest.getEnergyProviderId());
        address.setUser(user);
        address.setEnergyProvider(energyProvider);

        var savedAddress = addressRepository.save(address);
        userRepository.save(user);
        return savedAddress.getId();
    }

    public List<Address> getAddressByUserId(Long userId){
        Optional<List<Address>>
         addresses = addressRepository.findByUserId(userId);
        return addresses.orElseThrow(UserNotFoundException::new);
    }

    public Address getAddressById(Long id){
        Optional<Address> address = addressRepository.findById(id);
        return address.orElseThrow(AddressNotFoundException::new);
    }


    public AddressResponse update(Long userId, Long id, AddressRequest addressRequest) {
        try {
            Address address = getAddressById(id);
            BeanUtils.copyProperties(addressRequest, address);
            address.setCity(addressRequest.getCity());
            address.setCep(addressRequest.getCep());
            address.setHouseNumber(addressRequest.getHouseNumber());
            address.setInputVoltage(addressRequest.getInputVoltage());
            address.setNeighborhood(addressRequest.getNeighborhood());
            address.setNickname(addressRequest.getNickname());
            address.setMainAddress(addressRequest.isMainAddress());
            addressRepository.save(address);
            var addressResponse = new AddressResponse();
            BeanUtils.copyProperties(address, addressResponse);
            return addressResponse;
        } catch (RuntimeException notFoundException) {
            throw new AddressNotFoundException();
        }
    }

    public void delete(Long userId, Long id) {
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

    public Address getMainAddress(Long userId) {
        Optional<List<Address>> optionalAddresses = addressRepository.findByUserId(userId);
        List<Address> addresses = optionalAddresses.orElseThrow(UserNotFoundException::new);
        for (Address address : addresses) {
            if (address.isMainAddress()) {
                return address;
            }
        }
        throw new AddressNotFoundException();
    }

}


