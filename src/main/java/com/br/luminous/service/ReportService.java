package com.br.luminous.service;

import com.br.luminous.models.ReportResponse;
import com.br.luminous.repository.ConsumptionRepository;
import com.br.luminous.repository.ReportProjection;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {
    public ConsumptionRepository consumptionRepository;

    public List<ReportResponse> getReport(Long addressId) {
        List<ReportProjection> reportProjections = consumptionRepository.getReport(addressId);
        List<ReportResponse> reportResponses = new ArrayList<>();


        for (ReportProjection projection : reportProjections) {
            ReportResponse reportResponse = new ReportResponse();
            reportResponse.setPeriod(projection.getPeriod());
            reportResponse.setName(projection.getName());
            reportResponse.setEnergyConsumptionKWh(projection.getEnergyConsumptionKWh());
            reportResponse.setEnergyConsumptionReais(projection.getEnergyConsumptionReais());
            reportResponses.add(reportResponse);
        }

        return reportResponses;
    }

}