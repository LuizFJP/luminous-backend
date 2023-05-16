package com.br.luminous.service;

import com.br.luminous.models.AuthenticationRequest;
import com.br.luminous.models.AuthenticationResponse;
import com.br.luminous.models.UserRequest;
import com.br.luminous.entity.Token;
import com.br.luminous.entity.User;
import com.br.luminous.enums.TokenType;
import com.br.luminous.exceptions.EmailAlreadyExistsException;
import com.br.luminous.repository.TokenRepository;
import com.br.luminous.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;


    public AuthenticationResponse register(UserRequest userRequest) {
        try {
            userService.checkEmailAlreadyExists(userRequest.getEmail());
            var user = new User();
            BeanUtils.copyProperties(userRequest, user);
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            User savedUser = userRepository.save(user);
            var jwtToken = jwtService.generateToken(user, user.getId());
            saveUserToken(savedUser, jwtToken);
            return new AuthenticationResponse(jwtToken);
        } catch(EmailAlreadyExistsException e) {
            throw e;
        }


    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(
                           request.getEmail(),
                           request.getPassword()
                   )
           );
           var user = userRepository.findByEmail(request.getEmail())
                   .orElseThrow();
           var jwtToken = jwtService.generateToken(user, user.getId());
           revokeAllUserTokens(user);
           saveUserToken(user, jwtToken);
           return new AuthenticationResponse(jwtToken);
       } catch(AuthenticationException exception) {
           throw exception;
       }

    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
}