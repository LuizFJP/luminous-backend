package com.br.luminous.repository;

import com.br.luminous.entity.EnergyProvider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface EnergyProviderRepository extends CrudRepository<EnergyProvider, Long> {

    Optional<EnergyProvider> findByCompanyName(String companyName);
    EnergyProvider getById(Long id);
}
