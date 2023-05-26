package com.br.luminous.service;

import com.br.luminous.models.UserRequest;
import com.br.luminous.models.UserResponse;
import com.br.luminous.entity.User;
import com.br.luminous.exceptions.EmailAlreadyExistsException;
import com.br.luminous.exceptions.UserNotFoundException;
import com.br.luminous.models.UserUpdateRequest;
import com.br.luminous.models.UserUpdateResponse;
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
    public UserUpdateResponse update(Long id, UserUpdateRequest userUpdateRequest) {
        try {
            User user = getUserById(id);
            user = updateUser(user, userUpdateRequest);
            userRepository.save(user);
            var userUpdateResponse = new UserUpdateResponse();
            BeanUtils.copyProperties(user, userUpdateResponse);
            return userUpdateResponse;
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

    private User updateUser(User user, UserUpdateRequest userUpdateRequest) {
        if (userUpdateRequest.getUserName() != null)
            user.setUserName(userUpdateRequest.getUserName());
        if (userUpdateRequest.getBirthdate() != null)
            user.setBirthdate(userUpdateRequest.getBirthdate());
        if (userUpdateRequest.getPhone() != null)
            user.setPhone(userUpdateRequest.getPhone());
        if (userUpdateRequest.getName() != null)
            user.setName(userUpdateRequest.getName());
        if (userUpdateRequest.getPassword() != null)
            user.setPassword(passwordEncoder.encode(userUpdateRequest.getPassword()));
        return user;
    }
}
