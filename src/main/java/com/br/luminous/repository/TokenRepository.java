package com.br.luminous.repository;

import com.br.luminous.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query(value = """
      select t from Token t inner join User u\s
      on t.user.id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """)
    List<Token> findAllValidTokenByUser(Long id);
    @Transactional
    @Modifying
    @Query(value = """
      delete from Token as t\s
      where t.user.id = ?1\s
      """)
    void deleteAllByUser(Long id);
    Optional<Token> findByToken(String token);
}
