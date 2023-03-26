package com.br.luminous.repository;

import com.br.luminous.entity.Residence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ResidenceRepository extends CrudRepository<Residence, Long> {

}
