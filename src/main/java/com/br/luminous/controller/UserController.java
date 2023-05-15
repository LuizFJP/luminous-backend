package com.br.luminous.controller;

import com.br.luminous.DTO.EnergyProviderRequest;
import com.br.luminous.DTO.UserRequest;
import com.br.luminous.DTO.UserResponse;
import com.br.luminous.entity.User;
import com.br.luminous.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody UserRequest user){
        Long id = userService.create(user);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse user = userService.get(id);
        return new ResponseEntity<UserResponse>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest user) {
        userService.update(id, user);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
