package com.br.luminous.controller;

import com.br.luminous.models.AuthenticationRequest;
import com.br.luminous.models.AuthenticationResponse;
import com.br.luminous.models.UserRequest;
import com.br.luminous.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<Long> register(
            @RequestBody UserRequest request
    ) {
        return new ResponseEntity<Long>(service.register(request), HttpStatus.CREATED);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        var jwtToken = service.authenticate(request);
        return new ResponseEntity<AuthenticationResponse>(jwtToken, HttpStatus.OK);
    }

}
