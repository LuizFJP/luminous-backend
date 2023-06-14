package com.br.luminous.controller;

import com.br.luminous.models.*;
import com.br.luminous.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/password-recovery")
    public ResponseEntity<String> passwordRecovery(@RequestBody PasswordRecoveryRequest passwordRecoveryRequest){
        service.initiatePasswordRecovery(passwordRecoveryRequest.getEmail());
        return ResponseEntity.ok("Email de recuperação de senha enviado com sucesso");
    }
    @PostMapping("/password-reset")
    public ResponseEntity<String> passwordReset(@RequestParam(name = "token") String token, @RequestBody PasswordResetRequest passwordResetRequest){
        service.resetPassword(token, passwordResetRequest.getPassword(), passwordResetRequest.getEmail());
        return ResponseEntity.ok("Senha redefinida com sucesso.");
    }
}
