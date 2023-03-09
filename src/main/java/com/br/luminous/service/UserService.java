package com.br.luminous.service;

import com.br.luminous.entity.User;
import com.br.luminous.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public Long create(User user) {
       User response = userRepository.save(user);
       return response.getId();
    }
}
