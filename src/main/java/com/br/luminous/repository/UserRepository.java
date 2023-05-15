package com.br.luminous.repository;

import com.br.luminous.entity.Address;
import com.br.luminous.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findByEmail(String email);

}
