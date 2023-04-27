package com.br.luminous.repository;

import org.springframework.data.repository.CrudRepository;
import com.br.luminous.entity.Tip;
import org.springframework.stereotype.Repository;

@Repository
public interface TipRepository extends CrudRepository<Tip, Long> {
}
