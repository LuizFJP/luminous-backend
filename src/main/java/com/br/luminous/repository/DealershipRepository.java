package com.br.luminous.repository;

import com.br.luminous.entity.Dealership;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealershipRepository extends CrudRepository<Dealership, Long> {

}
