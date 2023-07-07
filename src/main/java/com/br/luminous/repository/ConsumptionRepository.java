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
            "SELECT "+
                    "name,DATE_TRUNC('month', period) period,"+
            " SUM(energy_consumptionkwh) energyConsumptionKWh,"+
            " SUM(energy_consumption_reais) energyConsumptionReais"+
            " FROM device"+
            " INNER JOIN consumption ON consumption.device_id = device.id"+
                    " inner join address " +
                    "on (:addressId) = device.address_id " +
            " GROUP BY name, DATE_TRUNC('month', period)"+
            " ORDER BY DATE_TRUNC('month', period)"
    )
    List<ReportProjection> getReport(Long addressId);
}
