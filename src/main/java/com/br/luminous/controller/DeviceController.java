package com.br.luminous.controller;
import com.br.luminous.entity.Device;
import com.br.luminous.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/user/address/devices")
public class DeviceController {

    private DeviceService deviceService;

    @GetMapping
    public ResponseEntity<List<Device>> getDevicesOfAddress(Long addressId) {
        List<Device> list = deviceService.findDevicesByAddressId(addressId);
        return new ResponseEntity<List<Device>>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Device> findById(@PathVariable Long id){
        Device device = deviceService.findDeviceById(id);
        return new ResponseEntity<Device> (device, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Long> createDevice(@RequestBody Device device, @PathVariable Long addressId){
        Long id = deviceService.create(device, addressId);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Device> update(@PathVariable Long id, @RequestBody Device device){
        device = deviceService.update(id, device);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)  {
        deviceService.delete(id);
        return new ResponseEntity (HttpStatus.OK);
    }
}
