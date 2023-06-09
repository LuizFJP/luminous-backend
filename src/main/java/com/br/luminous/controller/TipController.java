package com.br.luminous.controller;

import com.br.luminous.entity.Tip;
import com.br.luminous.exceptions.TipNotFoundException;
import com.br.luminous.service.TipService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tip")
    public class TipController {
    private TipService tipService;

    @PostMapping("/")
    public ResponseEntity<Long> create(@RequestBody Tip tip){
        Long id = tipService.create(tip);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tip> getTip(@PathVariable Long id){
        Tip tip = tipService.getTip(id);
        return new ResponseEntity<Tip>(tip, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tip> update(@PathVariable Long id, @RequestBody String message){
        Tip tip = tipService.update(id, message);
        return new ResponseEntity<>(tip, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Tip> delete(@PathVariable Long id){
        try{
            tipService.delete(id);
            return ResponseEntity.ok().build();
        }catch(TipNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
