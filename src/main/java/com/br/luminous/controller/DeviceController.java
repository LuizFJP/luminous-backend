package com.br.luminous.controller;
import com.br.luminous.DTO.UserRequest;
import com.br.luminous.DTO.UserResponse;
import com.br.luminous.entity.Device;
import com.br.luminous.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/user/devices")
public class DeviceController {

    private DeviceService deviceService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<String> teste() {
        return new ResponseEntity<String>
        ("Deu certo! \nAqui é a tela de dispositivos",
        HttpStatus.CREATED);
    }

    @PostMapping("/")
    public ResponseEntity<Long> createDevice(@RequestBody Device device){
        Long id = deviceService.create(device);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }
}
