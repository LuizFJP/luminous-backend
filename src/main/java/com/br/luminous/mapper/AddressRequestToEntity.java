package com.br.luminous.mapper;

import com.br.luminous.entity.Address;
import com.br.luminous.models.AddressRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddressRequestToEntity {

    public Address mapper (AddressRequest addressRequest){
        var address = new Address();

        BeanUtils.copyProperties(addressRequest, address);
        return address;
    }
}
