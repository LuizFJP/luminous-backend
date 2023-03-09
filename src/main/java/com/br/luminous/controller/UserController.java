package com.br.luminous.controller;

import com.br.luminous.entity.User;
import com.br.luminous.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<Long> createUser(@RequestBody User user) {
        Long id = userService.create(user);
        return new ResponseEntity<Long>(id, HttpStatus.CREATED);
    }
}
