package com.br.luminous.service;
import com.br.luminous.entity.Device;
import com.br.luminous.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeviceService {

    private DeviceRepository deviceRepository;
    public Long create(Device device){
        Device response = deviceRepository.save(device);
        return response.getId();
    }
}
