package com.br.luminous.mapper;

import org.springframework.beans.BeanUtils;
import com.br.luminous.models.DeviceRequest;
import com.br.luminous.entity.Device;
public class DeviceRequestToEntity {
    public Device mapper(DeviceRequest DeviceRequest){
        Device device = new Device();
        BeanUtils.copyProperties(DeviceRequest, device);
        return device;
    }
}
