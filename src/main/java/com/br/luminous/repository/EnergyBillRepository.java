package com.br.luminous.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.br.luminous.entity.EnergyBill;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnergyBillRepository extends CrudRepository<EnergyBill, Long> {
    @Override
    List<EnergyBill> findAll();
    @Query("SELECT eb FROM EnergyBill eb WHERE eb.address.id = :addressId")
    List<EnergyBill> findAllEnergyBillByAddress(@Param("addressId")Long addressId);


}
