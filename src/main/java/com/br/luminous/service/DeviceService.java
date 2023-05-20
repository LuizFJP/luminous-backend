package com.br.luminous.service;
import com.br.luminous.entity.Address;
import com.br.luminous.entity.Device;
import com.br.luminous.exceptions.DatabaseException;
import com.br.luminous.exceptions.DeviceNotFoundException;
import com.br.luminous.exceptions.AddressNotFoundException;
import com.br.luminous.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class DeviceService {

    private DeviceRepository deviceRepository;

    public List<Device> findDevicesByAddressId(Long addressId){
        Optional<List<Device>> devices = deviceRepository.findByAddressId(addressId);
        return devices.orElseThrow(AddressNotFoundException::new);
    }

    public Device findDeviceById(Long id){
        Optional<Device> obj = deviceRepository.findById(id);
        return obj.orElseThrow(DeviceNotFoundException::new);
    }

    public Device insert(Device obj){
        return deviceRepository.save(obj);
    }

    public void delete (Long id){
        try{
            deviceRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new DeviceNotFoundException();
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException("non-existent device");
        }
    }

    public Device update (Long id, Device obj){
        try{
            Device entity = findDeviceById(id);
            updateData(entity, obj);
            return deviceRepository.save(entity);
        }catch (EntityNotFoundException e){
            throw new DeviceNotFoundException();
        }
    }
    public Long create(Device device, Long addressId){
        Device response = deviceRepository.save(device);
        return response.getId();
    }

    private void updateData(Device device, Device obj) {
        device.setName(obj.getName());
        device.setPower(obj.getPower());
        device.setUsageTime(obj.getUsageTime());
    }
}
