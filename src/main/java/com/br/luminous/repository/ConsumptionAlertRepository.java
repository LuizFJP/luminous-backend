package com.br.luminous.repository;

import com.br.luminous.entity.ConsumptionAlert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionAlertRepository extends CrudRepository<ConsumptionAlert, Long> {


}
