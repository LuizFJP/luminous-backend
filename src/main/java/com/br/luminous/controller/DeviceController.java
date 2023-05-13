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

    private DeviceService service;

    @GetMapping
    public ResponseEntity<List<Device>> findAll() {
        List<Device> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Device> findById(@PathVariable Long id){
        Device obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/")
    public ResponseEntity<Long> createDevice(@RequestBody Device device){
        Long id = service.create(device);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Device> update(@PathVariable Long id, @RequestBody Device obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)  {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
