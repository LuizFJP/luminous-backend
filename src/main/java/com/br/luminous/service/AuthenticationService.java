package com.br.luminous.service;

import com.br.luminous.exceptions.UserNotFoundException;
import com.br.luminous.models.AuthenticationRequest;
import com.br.luminous.models.AuthenticationResponse;
import com.br.luminous.models.UserRequest;
import com.br.luminous.entity.Token;
import com.br.luminous.entity.User;
import com.br.luminous.enums.TokenType;
import com.br.luminous.exceptions.EmailAlreadyExistsException;
import com.br.luminous.repository.TokenRepository;
import com.br.luminous.repository.UserRepository;
import javassist.NotFoundException;
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

    private final EmailService emailService;


    public Long register(UserRequest userRequest) {
        try {
            userService.checkEmailAlreadyExists(userRequest.getEmail());
            var user = new User();
            BeanUtils.copyProperties(userRequest, user);
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            User savedUser = userRepository.save(user);
            return savedUser.getId();
        } catch(EmailAlreadyExistsException emailAlreadyExistsException) {
            throw emailAlreadyExistsException;
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

    public void initiatePasswordRecovery(String email){
        var user = userService.findByEmail(email);
        if(user == null) {
            throw new UserNotFoundException();
        }
        String token = jwtService.generateToken(user, user.getId());
        String recoveryUrl = "http://localhost:3000/password/reset" + "?token=" + token;
        String subject = "Recuperação de senha";
        String message = "Olá" + user.getName() + ",\n\n" +
        "Você solicitou a recuperação de senha. Para criar uma nova senha clique no link abaixo: \n"
                + recoveryUrl + "\n\n" +
                "Caso você não tenha solicitado a recuperação de senha, ignore este e-mail \n\n"
                + "Atenciosamente, \n" +
                "Equipe Luminous";
        emailService.sendEmail(user.getEmail(), subject, message);
    }

    public void resetPassword(String token, String newPassword, String userEmail){
        var user = userService.findByEmail(userEmail);
        var passwordResetToken = jwtService.isTokenValid(token, user);
        if(passwordResetToken){
            userService.resetUserPassword(user, newPassword);
            String subject = "Senha Redefinida";
            String message = "Olá " + user.getName() + ", \n\n" +
                    "Sua senha foi redefinida com sucesso. \n\n" +
                    "Atenciosamente, \n" +
                    "Equipe Luminous";
            emailService.sendEmail(user.getEmail(), subject, message);
        }else{
            throw new IllegalArgumentException();
        }
    }
}