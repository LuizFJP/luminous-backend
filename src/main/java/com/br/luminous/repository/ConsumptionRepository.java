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
                    "WHERE consumption.period >= (select * from vw_last_restart_day);")
    List<TrackProjection> getCurrentConsumption(Long addressId);


    @Query(nativeQuery = true, value =
            "select " +
                    "name name, SUM(energy_consumptionKWh) energyConsumptionKWh," +
                    " SUM(energy_consumption_reais) energyConsumptionReais, DATE_TRUNC('month', period) period" +
            " FROM device " +
            " INNER JOIN consumption " +
            " ON consumption.device_id = device.id" +
            " GROUP BY device.name, period" +
            " ORDER BY period, energyConsumptionReais DESC, energyConsumptionKWh DESC")
    List<ReportProjection> getReport(Long addressId);
}
