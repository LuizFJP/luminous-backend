package com.br.luminous.repository;

import org.springframework.data.repository.CrudRepository;
import com.br.luminous.entity.EnergyBill;
import org.springframework.stereotype.Repository;
@Repository
public interface EnergyBillRepository extends CrudRepository<EnergyBill, Long> {

}
