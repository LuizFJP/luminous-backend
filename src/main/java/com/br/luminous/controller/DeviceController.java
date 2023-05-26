package com.br.luminous.controller;
import com.br.luminous.entity.Device;
import com.br.luminous.models.DeviceRequest;
import com.br.luminous.models.DeviceResponse;
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

    @GetMapping("all/address/{addressId}")
    public ResponseEntity<List<Device>> getDevicesOfAddress(@PathVariable Long addressId) {
        List<Device> list = deviceService.findDevicesByAddressId(addressId);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/address/{addressId}")
    public ResponseEntity<Long> createDevice(@RequestBody DeviceRequest device, @PathVariable Long addressId){
        Long response = deviceService.create(device, addressId);
        return new ResponseEntity<Long>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}/address/{addressId}")
    public ResponseEntity<DeviceResponse> update(@PathVariable Long id, @RequestBody DeviceRequest device, @PathVariable Long addressId){
        deviceService.update(id, device, addressId);
        return new ResponseEntity(device, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}/address/{addressId}")
    public ResponseEntity<DeviceResponse> delete(@PathVariable Long id, @PathVariable String addressId)  {
        deviceService.delete(id);
        return new ResponseEntity (HttpStatus.OK);
    }
}
