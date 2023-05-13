package com.br.luminous.controller;

import com.br.luminous.models.WhiteTaxResponse;
import com.br.luminous.service.WhiteTaxService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/white-taxes")
public class WhiteTaxController {
    private WhiteTaxService whiteTaxService;

    @GetMapping("/")
    public ResponseEntity<List<WhiteTaxResponse>> getWhiteTaxes() {
        var response = whiteTaxService.getAll();
        return new ResponseEntity<List<WhiteTaxResponse>>(
               response , HttpStatus.OK);
    }

}
