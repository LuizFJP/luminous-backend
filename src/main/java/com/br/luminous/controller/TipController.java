package com.br.luminous.controller;

import com.br.luminous.entity.Tip;
import com.br.luminous.service.TipService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tip")
    public class TipController {
    private TipService tipService;

    @GetMapping("/{id}")
    public ResponseEntity<Tip> getTip(Long id){
        Tip tip = tipService.getTip(id);
        return new ResponseEntity<Tip>(tip, HttpStatus.OK);
    }
}
