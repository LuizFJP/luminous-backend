package com.br.luminous.controller;

import com.br.luminous.models.ReportResponse;
import com.br.luminous.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/report")
public class ReportController {

    private ReportService reportService;

    @GetMapping("/address/{addressId}")
    public ResponseEntity<List<ReportResponse>> getReport(@PathVariable Long addressId){
      List<ReportResponse> reportResponses = reportService.getReport(addressId);
        return ResponseEntity.ok(reportResponses);
    }

}
