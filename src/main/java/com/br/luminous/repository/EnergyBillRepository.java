package com.br.luminous.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.br.luminous.entity.EnergyBill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnergyBillRepository extends CrudRepository<EnergyBill, Long> {
    @Override
    List<EnergyBill> findAll();
    @Query(value = """
      select eb from EnergyBill eb inner join Address a\s
      on eb.address.id = a.id\s
      """)
    List<EnergyBill> findAllByAddressId();


}
