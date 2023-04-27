package com.br.luminous.service;

import com.br.luminous.DTO.UserRequest;
import com.br.luminous.DTO.UserResponse;
import com.br.luminous.entity.User;
import com.br.luminous.exceptions.EmailAlreadyExistsException;
import com.br.luminous.entity.Address;
import com.br.luminous.exceptions.UserNotFoundException;
import com.br.luminous.repository.AddressRepository;
import com.br.luminous.repository.TokenRepository;
import com.br.luminous.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;


    public UserResponse get(Long id) {
        try {
            var user = getUserById(id);
            var userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);
            return userResponse;
        } catch (RuntimeException notFoundException) {
            throw new UserNotFoundException();
        }
    }
    public UserResponse update(Long id, UserRequest userRequest) {
        try {
            User user = getUserById(id);
            BeanUtils.copyProperties(userRequest, user);
            user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
            userRepository.save(user);
            var userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);
            return userResponse;
        } catch (RuntimeException notFoundException) {
            throw new UserNotFoundException();
        }
    }

    public void delete(Long id) {
        try {
            getUserById(id);
            tokenRepository.deleteAllByUser(id);
            userRepository.deleteById(id);
        } catch (RuntimeException notFoundException) {
            throw new UserNotFoundException();
        }
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(UserNotFoundException::new);
    }

    public void checkEmailAlreadyExists(String email) throws EmailAlreadyExistsException {
        userRepository.findByEmail(email).ifPresent(a -> {
                throw new EmailAlreadyExistsException();
        });
    }
}
