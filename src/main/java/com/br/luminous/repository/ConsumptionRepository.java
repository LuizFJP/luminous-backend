package com.br.luminous.repository;

import com.br.luminous.entity.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {

    @Query(nativeQuery = true, value=
            "select" +
                    " sum(energy_consumptionkwh) energyConsumptionKWh, sum(energy_consumption_reais) energyConsumptionReais" +
                    " from consumption " +
                    "inner join device "+
                    "on device.id = consumption.device_id " +
                    "inner join address " +
                    "on (:addressId) = device.address_id " +
                    "WHERE consumption.period >= (2023-06-10);")
    List<TrackProjection> getCurrentConsumption(Long addressId);

}
