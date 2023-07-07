package com.br.luminous.controller;

import com.br.luminous.service.BillFileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/billFile")
public class BillFileController {
    private final BillFileService billFileService;

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFile(MultipartFile file) {
        try {
            Long id = billFileService.uploadBillFile(file);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file.");
        }
    }
    @GetMapping("/download/{energyBillId}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("energyBillId") Long energyBillId) {
        try{
            return billFileService.downloadBillFile(energyBillId);
        }catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
