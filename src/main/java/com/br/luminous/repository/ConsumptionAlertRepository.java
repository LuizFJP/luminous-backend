package com.br.luminous.repository;

import com.br.luminous.entity.ConsumptionAlert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumptionAlertRepository extends CrudRepository<ConsumptionAlert, Long> {
    @Override
    List<ConsumptionAlert> findAll();
    @Query("SELECT ca FROM ConsumptionAlert ca WHERE ca.address.id = :addressId")
    List<ConsumptionAlert> getAllByAddress(@Param("addressId")Long addressId);
}
