package com.br.luminous.service;

import com.br.luminous.DTO.UserRequest;
import com.br.luminous.entity.User;
import com.br.luminous.exceptions.UserNotFoundException;
import com.br.luminous.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public void update(Long id, UserRequest userRequest) {
        try {
            User user = getUserById(id);
            BeanUtils.copyProperties(userRequest, user);
            userRepository.save(user);
        } catch (RuntimeException notFoundException) {
            throw new UserNotFoundException();
        }
    }

    public void delete(Long id) {
        try {
            getUserById(id);
            userRepository.deleteById(id);
        } catch (RuntimeException notFoundException) {
            throw new UserNotFoundException();
        }

    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(UserNotFoundException::new);
    }


}
