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
@RequestMapping("api/device")
public class DeviceController {

    private DeviceService deviceService;

    @GetMapping("/addresses/{addressId}")
    public ResponseEntity<List<Device>> getDevicesOfAddress(@PathVariable Long addressId) {
        List<Device> list = deviceService.findDevicesByAddressId(addressId);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/address")
    public ResponseEntity<Device> findById(@PathVariable Long id){
        Device device = deviceService.findDeviceById(id);
        return new ResponseEntity<Device> (device, HttpStatus.OK);
    }

    @PostMapping("/addresses/{addressId}")
    public ResponseEntity<Long> createDevice(@RequestBody Device device, @PathVariable Long addressId){
        Long id = deviceService.create(device, addressId);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}/address/{addressId}")
    public ResponseEntity<Device> update(@PathVariable Long addressId, @PathVariable Long id, @RequestBody Device device){
        device = deviceService.update(addressId, id, device);
        return new ResponseEntity(device, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/addresses/{addressId}")
    public ResponseEntity<Void> delete(@PathVariable Long id)  {
        deviceService.delete(id);
        return new ResponseEntity (HttpStatus.OK);
    }
}
